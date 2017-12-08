package com.ljm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljm.entity.SmbmsProvider;

public interface SmbmsProviderMapper {
	List<SmbmsProvider> getSmbmsProviderList();

	List<SmbmsProvider> getPageProviders(
			@Param("proCode") String proCode, @Param("proName") String proName,
			@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

	int getCountProviders(@Param("proCode") String proCode,
			@Param("proName") String proName);
	
	int addProvider(SmbmsProvider provider);
	
	SmbmsProvider getpProviderById(Long id);

}
