package com.ljm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljm.dao.SmbmsBillMapper;
import com.ljm.entity.SmbmsBill;
import com.ljm.service.SmbmsBillService;

@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
	@Autowired
	private SmbmsBillMapper mapper;

	public List<SmbmsBill> getBillByPnameAndPIdAndPay(String productName,
			Integer providerId, Integer isPayment, int pizeNo, int pizeSize) {
		return mapper.getBillByPnameAndPIdAndPay(productName, providerId,
				isPayment, (pizeNo - 1) * pizeSize, pizeSize);
	}

	public int getCountBills(String productName, Integer providerId,
			Integer isPayment) {
		return mapper.getCountBills(productName, providerId, isPayment);
	}

	public int addSmbmsBill(SmbmsBill bill) {
		return mapper.addSmbmsBill(bill);
	}

	public int updateSmbmsBillById(SmbmsBill bill) {
		return mapper.updateSmbmsBillById(bill);
	}

	public int delSmbmsBillById(Integer id) {
		return mapper.delSmbmsBillById(id);
	}

}
