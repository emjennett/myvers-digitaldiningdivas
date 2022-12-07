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

    /**
     * Initiate a UserFile.
     * @param csvpath the file to be created or opened.
     */
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

    /**
     * A find request for a specific user.
     * @param username if found in the file return true otherwise return false.
     */
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

    /**
     * A security check to log in a user.
     * @param username to be found in the file if not found return false.
     * @param password if password is linked to the username found return true otherwise false.
     */
    @Override
    public String confirmAccountUser(String username, String password){

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
                return found.getType();
            }
        }
        return "no";
    }
    /**
     * A request to create a new user in the file.
     * @param model to be stored away in the file.
     */
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
