package com.ps.filemanager;

import com.ps.model.Contract;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {
    public static void saveContract(Contract contract) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv",true));
            bufferedWriter.write("\n" + contract.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}