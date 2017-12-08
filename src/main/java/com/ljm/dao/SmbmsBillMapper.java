package com.ljm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.ljm.entity.SmbmsBill;

public interface SmbmsBillMapper {

	List<SmbmsBill> getBillByPnameAndPIdAndPay(
			@Param("productName") String productName,
			@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment, @Param("pizeNo") int pizeNo,
			@Param("pizeSize") int pizeSize);

	int getCountBills(
			@Param("productName") String productName,
			@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);
			
	
	int addSmbmsBill(SmbmsBill bill);

	
	int updateSmbmsBillById(SmbmsBill bill);

	int delSmbmsBillById(Integer id);
}
