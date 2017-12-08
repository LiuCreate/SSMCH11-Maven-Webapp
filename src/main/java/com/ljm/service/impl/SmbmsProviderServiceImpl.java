package com.ljm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljm.dao.SmbmsProviderMapper;
import com.ljm.entity.SmbmsProvider;
import com.ljm.service.SmbmsProviderService;

@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
	@Autowired
	private SmbmsProviderMapper mapper;

	public List<SmbmsProvider> getSmbmsProviderList() {
		return mapper.getSmbmsProviderList();
	}

	public List<SmbmsProvider> getPageProviders(String proCode, String proName,
			int pageNo, int pageSize) {

		return mapper.getPageProviders(proCode, proName, (pageNo - 1)
				* pageSize, pageSize);
	}

	public int getCountProviders(String proCode, String proName) {

		return mapper.getCountProviders(proCode, proName);
	}

	public int addProvider(SmbmsProvider provider) {

		return mapper.addProvider(provider);
	}

	public SmbmsProvider getpProviderById(Long id) {
		return mapper.getpProviderById(id);
	}

}
