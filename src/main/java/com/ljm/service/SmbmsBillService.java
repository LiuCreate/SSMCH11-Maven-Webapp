package com.ljm.service;

import java.util.List;

import com.ljm.entity.SmbmsBill;

public interface SmbmsBillService {
	
	List<SmbmsBill> getBillByPnameAndPIdAndPay(String productName,Integer providerId,Integer isPayment,int pizeNo,int pizeSize);

	int getCountBills(String productName,Integer providerId,Integer isPayment);
	
	int addSmbmsBill(SmbmsBill bill);

	
	int updateSmbmsBillById(SmbmsBill bill);

	int delSmbmsBillById(Integer id);
}
