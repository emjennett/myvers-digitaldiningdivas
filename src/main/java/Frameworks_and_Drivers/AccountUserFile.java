package Frameworks_and_Drivers;
import APP_Business_Rules.login_user.AccountUserGateway;
import APP_Business_Rules.login_user.LoginUserGatewayModel;


import java.io.*;
import java.util.HashMap;

import java.util.Map;

public class AccountUserFile implements AccountUserGateway {

    private final File txtFile;

    public AccountUserFile(String txtpath) {

        this.txtFile = new File(txtpath);
        Map<String, LoginUserGatewayModel> accounts = new HashMap<>();

        if (txtFile.length() == 0) {

            try {
                FileOutputStream file = new FileOutputStream(txtFile);
                ObjectOutputStream writer = new ObjectOutputStream(file);
                writer.writeObject(accounts);
                file.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public LoginUserGatewayModel loadAccount(LoginUserGatewayModel model) {

        Map<String, LoginUserGatewayModel> accounts;

        try{
            FileInputStream file = new FileInputStream(this.txtFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            accounts = (Map) reader.readObject();
            reader.close();
            file.close();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (accounts.containsKey(model.getUsername())){
            return accounts.get(model.getUsername());
        }
        accounts.put(model.getUsername(), model);
        try{
            FileOutputStream file = new FileOutputStream(txtFile);
            ObjectOutputStream writer = new ObjectOutputStream(file);
            writer.writeObject(accounts);
            file.close();
            writer.close();
        }
        catch (IOException e) {
                throw new RuntimeException(e);
            }
        return model;
    }
}
