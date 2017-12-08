package com.ljm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljm.entity.SmbmsProvider;

public interface SmbmsProviderService {
	List<SmbmsProvider> getSmbmsProviderList();

	List<SmbmsProvider> getPageProviders(String proCode, String proName,
			int pageNo, int pageSize);

	int getCountProviders(String proCode, String proName);

	
	int addProvider(SmbmsProvider provider);
	
	SmbmsProvider getpProviderById(Long id);
}
