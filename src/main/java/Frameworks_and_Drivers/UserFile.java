package Frameworks_and_Drivers;
import APP_Business_Rules.create_user.CreateUserGateway;
import APP_Business_Rules.create_user.CreateUserGatewayModel;
import APP_Business_Rules.login_user.LoginUserGateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserFile implements CreateUserGateway, LoginUserGateway {

    private final File csvFile;


    public UserFile(String csvpath) {

        this.csvFile = new File(csvpath);
        List<CreateUserGatewayModel> users = new ArrayList<>();

        if (csvFile.length() == 0){

            try{
                FileOutputStream file = new FileOutputStream(csvFile);
                ObjectOutputStream writer = new ObjectOutputStream(file);
                writer.writeObject(users);
                file.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public boolean findAccountUser(String username) {

        List<CreateUserGatewayModel> users;

        try{
            FileInputStream file = new FileInputStream(this.csvFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            users = (List) reader.readObject();
            reader.close();
            file.close();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (CreateUserGatewayModel found : users) {
            if (Objects.equals(found.getUsername(), username)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean confirmAccountUser(String username, String password){

        List<CreateUserGatewayModel> users;

        try{
            FileInputStream file = new FileInputStream(this.csvFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            users = (List) reader.readObject();
            reader.close();
            file.close();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (CreateUserGatewayModel found : users) {
            if (Objects.equals(found.getUsername(), username) &&
                    Objects.equals(found.getPassword(), password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(CreateUserGatewayModel model) {

        List<CreateUserGatewayModel> users;

        try{
            FileInputStream file = new FileInputStream(this.csvFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            users = (List) reader.readObject();
            reader.close();
            file.close();
            users.add(model);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try{
            FileOutputStream file = new FileOutputStream(csvFile);
            ObjectOutputStream writer = new ObjectOutputStream(file);
            writer.writeObject(users);
            file.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
