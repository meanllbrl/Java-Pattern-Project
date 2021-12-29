package com.mycompany.oop1.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeComposite {

    Employee employeeList;

    public EmployeeComposite(Employee newEmployeeList) {
        employeeList = newEmployeeList;
    }

    public void getEmployeeList() {
        employeeList.displayEmployeeInfo(false);
    }

    public Employee getEmployee() {
        return employeeList;
    }

    public static EmployeeComposite processTxtFile() {
        // ana director
        Director rootDirector = null;
        // örnek girdi
        String txtList = ""; // girdi texte dönüşüyoe
        try {
            File myObj = new File("../oop1/src/main/java/com/mycompany/oop1/girdi.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                txtList += data + "/";
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Böyle bir dosya bulunamadı");
            // e.printStackTrace();
        }
        String[] list = txtList.split("/");
        // root eklenyor
        String[] theRoot = null;
        // listedeki her eleman için arama yapılıyor
        for (String eleman : list) {
            String[] parameters = eleman.split(",");
            // composite design patter'ın kökü belirleniyor
            if (parameters[3].trim().equalsIgnoreCase("root")) {
                Director _director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                rootDirector = _director;
                theRoot = parameters; // örnek theRoot = ["D","NameSurname","Salary","RootName"]
            }
            // eğer köke sahipse children'ların durumu kontrol ediliyor
            else {
                if (theRoot == null) {
                    theRoot = parameters;
                }
                // eğer altında çalışan kişi bulunursa director'a ait olan employeelist'e
                // ekleniyor
                if (parameters[3].trim().equalsIgnoreCase(theRoot[1].split(" ")[0].trim())) {
                    // director ise director nesnesi ekleniyor
                    if (parameters[0].trim().equalsIgnoreCase("d")) {
                        Director _director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                        rootDirector.add(_director);

                    } else {
                        // officersa officer nesnesi ekleniyor
                        Officer _officer = new Officer(parameters[1], Integer.parseInt(parameters[2]));
                        rootDirector.add(_officer);
                    }
                    // kök ve üst seviye çocuklar elde edildikten sonra döngü kırılıyor
                } else {
                    break;
                }
            }
        }
        // rootun altındaki childrenları almak için getChildren isimli recursive metod
        // oluşturuldu.
        getChildren(rootDirector, list);
        return new EmployeeComposite(rootDirector);
    }

    private static void getChildren(Director rootDirector, String[] list) {
        // root çocuk uzunluğu
        int size = rootDirector.getChildren().size();
        // her rootun altındakiler inceleniyor
        for (int i = 0; i < size; i++) {
            // Çocuğun Director olma durumu kontrol ediliyor
            if (rootDirector.getChildren().get(i).getClass() == Director.class) {
                Director element = (Director) rootDirector.getChildren().get(i);

                for (String parameter : list) {
                    String[] parameters = parameter.split(",");
                    if (element.getName().equals(parameters[3].trim())) {
                        if (parameters[0].toLowerCase().equalsIgnoreCase("d")) {
                            Director director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                            element.add(director);
                            if (!element.getChildren().isEmpty()) {// directorun çocukları var yok mu kontrol ediliyor
                                getChildren(element, list);// eğer varsa directoru root yapıp onun çocuklarını aramasını
                                                           // gerçekleştiriyor
                            }

                        } else {
                            Officer officer = new Officer(parameters[1], Integer.parseInt(parameters[2]));
                            if (element.getChildren().size() == 0) {
                                element.add(officer);
                            } else {
                                if (!element.contains(officer)) {
                                    element.add(officer);
                                }

                            }

                        }

                    }
                }
            }

        }
    }


    public void getCost() {

        employeeList.displayEmployeeInfo(true);
    }

}
