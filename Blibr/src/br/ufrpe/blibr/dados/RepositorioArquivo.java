package br.ufrpe.blibr.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RepositorioArquivo implements Serializable{
	public static Object lerDoArquivo(String filename) {
        Object obj = null;

        try {
        	FileInputStream fis = new FileInputStream(filename);
        	if(fis==null){//O erro é aqui
        		ObjectInputStream ois = new ObjectInputStream(fis);
                obj = (Object)ois.readObject();
                ois.close();
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void salvarArquivo(Object instance, String filename) {

        try {
        	FileOutputStream fos = new FileOutputStream(filename);
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
