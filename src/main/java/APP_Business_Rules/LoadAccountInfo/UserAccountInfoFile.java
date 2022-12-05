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


//    public void change(String username, String newbio){
//        List<UserAccountInfoModel> users;
//
//        try{
//            FileInputStream file = new FileInputStream(this.csvFile);
//            ObjectInputStream reader = new ObjectInputStream(file);
//            users = (List) reader.readObject();
//            reader.close();
//            file.close();
//        }
//        catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        for (UserAccountInfoModel found : users) {
//            if (Objects.equals(found.getUser(), username)) {
//                users.remove(found);
//                UserAccountInfoModel newuser = new UserAccountInfoModel(username);
//                newuser.changeBio(newbio);
//                users.add(newuser);
//            }
//        }
//
//    }
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
//            String namekey = model.getUser();
//            UserAccountInfoModel newmodel = new UserAccountInfoModel(namekey);
//            newmodel.changeBio(newbio);
//            users.add(newmodel);
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





