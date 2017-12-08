package com.ljm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ljm.entity.SmbmsBill;
import com.ljm.entity.SmbmsProvider;
import com.ljm.entity.SmbmsUser;
import com.ljm.service.SmbmsBillService;
import com.ljm.service.SmbmsProviderService;
import com.ljm.service.SmbmsUserService;

@Controller
@RequestMapping("user")
public class SmbmsBillController {
	@Autowired
	private SmbmsUserService userService;
	@Autowired
	private SmbmsBillService billService;
	@Autowired
	private SmbmsProviderService providerService;

	@RequestMapping("login.do")
	public String login(SmbmsUser user, HttpSession session) {
		SmbmsUser loginUser = userService.login(user);
		if (loginUser != null) {
			session.setAttribute("userSession", loginUser);
			return "jsp/frame";
		}
		return "login";
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userSession");
		return "login";
	}

	@RequestMapping("user.do")
	public String getUserList(HttpSession session) {
		List<SmbmsUser> userList = userService.getSmbmsUsersList();
		session.setAttribute("userList", userList);
		return "jsp/userlist";
	}

	private int pageSize = 5;

	@RequestMapping("bill.do")
	public String bill(String queryProductName, Integer queryProviderId,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			Integer queryIsPayment, HttpSession session) {

		int totalCount = billService.getCountBills(queryProductName,
				queryProviderId, queryIsPayment);

		int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;

		List<SmbmsProvider> providerList = providerService
				.getSmbmsProviderList();
		List<SmbmsBill> billList = billService.getBillByPnameAndPIdAndPay(
				queryProductName, queryProviderId, queryIsPayment, pageIndex,
				pageSize);

		session.setAttribute("providerList", providerList);
		session.setAttribute("billList", billList);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("totalPageCount", totalPageCount);
		session.setAttribute("currentPageNo", pageIndex);
		session.setAttribute("queryProductName", queryProductName);
		session.setAttribute("queryProviderId", queryProviderId);
		session.setAttribute("queryIsPayment", queryIsPayment);
		return "jsp/billlist";
	}

	@RequestMapping("provider.do")
	public String provider(String queryProCode, String queryProName,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			HttpSession session) {

		int totalCount = providerService.getCountProviders(queryProCode,
				queryProName);

		int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;

		List<SmbmsProvider> providerList = providerService.getPageProviders(
				queryProCode, queryProName, pageIndex, pageSize);

		session.setAttribute("providerList", providerList);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("totalPageCount", totalPageCount);
		session.setAttribute("currentPageNo", pageIndex);
		session.setAttribute("queryProCode", queryProCode);
		session.setAttribute("queryProName", queryProName);
		return "jsp/providerlist";
	}

	// ///////////////////////////////////////////////////////////////////////////////

	@RequestMapping("goAddProvider.do")
	public String goAddProvider(Map<String, Object> model, HttpSession session) {
		model.put("provider", new SmbmsProvider());
		return "jsp/provideradd";
	}

	@RequestMapping("addProvider.do")
	public String addProvider(
			@ModelAttribute("provider") @Valid SmbmsProvider provider,
			BindingResult result,
			@RequestParam("photos") MultipartFile[] photos,
			HttpServletRequest req) {
		if (!result.hasErrors()) {
			String path = req.getSession().getServletContext()
					.getRealPath("photos");
			List<String> errors = new ArrayList<String>();
			List<String> filenames = new ArrayList<String>();
			for (MultipartFile photo : photos) {
				String err = getErrInfo(photo);
				if (err == null) {
					String fileName = upload(photo, path);
					filenames.add(fileName);
				} else {
					errors.add(err);
				}

			}
			if (filenames.size() > 0) {
				provider.setProImage("photos" + "/"
						+ filenames.get(0));
				if (providerService.addProvider(provider) > 0) {
					return "redirect:provider.do";
				}
			}
			req.setAttribute("errors", errors);
			req.setAttribute("filenames", filenames);
		}
		return "jsp/addProvider";
	}

	public String upload(MultipartFile photo, String path) {
		String fileName = photo.getOriginalFilename();
		long time = System.currentTimeMillis();
		int randNumber = RandomUtils.nextInt(1000000);
		File dest = new File(path, time + "_" + randNumber + "_" + fileName);
		fileName=time + "_" + randNumber + "_" + fileName;
		try {
			photo.transferTo(dest);
			return fileName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getErrInfo(MultipartFile photo) {
		String fileName = photo.getOriginalFilename();
		String suf = FilenameUtils.getExtension(fileName);
		String err = null;
		if (photo.isEmpty()) {
			err = String.format("%s：上传文件不能为空", fileName);
		} else if (photo.getSize() > 500000) {
			err = String.format("%s：上传文件大小不能超过500KB", fileName);
		} else if (!formats.contains(suf.toLowerCase())) {
			err = String.format("%s：上传文件格式不正确，支持的格式：%s", fileName, formats);
		}
		return err;
	}

	static List<String> formats = new ArrayList<String>();
	static {
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}

	@RequestMapping("getProvider.do")
	public String getProvider(Long id,HttpSession session) {
		SmbmsProvider provider=providerService.getpProviderById(id);
		session.setAttribute("provider", provider);
		return "jsp/providerview";
	}
}
