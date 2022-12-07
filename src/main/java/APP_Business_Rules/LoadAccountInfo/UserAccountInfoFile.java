package APP_Business_Rules.LoadAccountInfo;
import APP_Business_Rules.create_user.CreateUserGatewayModel;
import APP_Business_Rules.login_user.LoginUserGatewayModel;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserAccountInfoFile implements LoadAccountGateway {

    private final File csvFile;



    public UserAccountInfoFile(String csvpath) {

        this.csvFile = new File(csvpath);
        List<UserAccountInfoModel> users = new ArrayList<>();

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
     * findAccountUser:
     * Returns whether a UserAccountInfoModel corresponding to the username has been stored in the csv file.
     *
     * @param username the username UserAccountInfomodel the will be returned.
     *
     * @return whether there is a UserAccountInfoModel that contains the username.
     *
     */

    @Override
    public boolean findAccountUser(String username) {

        List<UserAccountInfoModel> users;

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
        for (UserAccountInfoModel found : users) {
            if (Objects.equals(found.getUser(), username)) {
                return true;
            }
        }
        return false;
    }
    /**
     * load:
     * method that accesses the account csv and load and return the UserAccountInfomodel corresponding to the username.
     *
     * @param username the username UserAccountInfomodel the will be returned.
     *
     * @return the UserAccountInfomodel  that matches the username.
     *
     */

    @Override
    public UserAccountInfoModel load(String username) {

        List<UserAccountInfoModel> users;

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
        for (UserAccountInfoModel found : users) {
            if (Objects.equals(found.getUser(), username)) {
                return found;
            }
        }
        return new UserAccountInfoModel("none");
    }
    /**
     * save:
     * method that saves a  brand new UserAccountInfomodel in the csv file.
     * and saves it into the csv file
     *
     * @param model the UserAccountInfomodel that will be saved
     *
     */


    @Override
    public void save(UserAccountInfoModel model) {

        List<UserAccountInfoModel> users;

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
    /**
     * change:
     * method that accesses the UserAccountInfomodel in the csv file. and updates the bio of the UserAccountInfomodel
     * and saves it into the csv file
     *
     * @param Username the username of the account
     *
     * @param newbio the new bio that will be saved
     *
     */


    @Override
    public void change(String Username, String newbio) {

        List<UserAccountInfoModel> users;


        try{
            FileInputStream file = new FileInputStream(this.csvFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            users = (List) reader.readObject();
            for (UserAccountInfoModel x : users){
                if (Objects.equals(x.getUser(), Username)){
                    x.changeBio(newbio);
                }
            }
            reader.close();
            file.close();

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





