package com.mycompany.oop1.classes;

import com.mycompany.oop1.Iterator.TreeNode;

public class EmployeeComposite {

    Employee employeeList;

    public EmployeeComposite(Employee newEmployeeList) {
        employeeList = newEmployeeList;
    }

    public void getEmployeeList() {
        employeeList.displayEmployeeInfo();
    }

    public Employee getEmployee() {
        return employeeList;
    }

    public static EmployeeComposite processTxtFile() {
        Director rootDirector = null;

        String txtList = "D,Mustafa Turksever,5000,Root/D,Halil Sengonca,4000,Mustafa/D,Bahar Karaoglan,3500,Mustafa/D,Ugur Guclu,2000,Halil/D,Sedat Tunc,2500,Halil/D,Oguz Demir,3000,Halil/M,Emre Kosar,700,Ugur/M,Ahmet Egeli,700,Ugur/M,Bora Kuzey,1000,Sedat/M,Onder Bati,500,Oguz/M,Erdem Altin,500,Oguz/M,Mehmet Bilir,600,Mustafa";
        String[] list = txtList.split("/");
        // root eklenyor
        TreeNode<Employee> root = null;
        String[] theRoot = null;
        for (String eleman : list) {
            String[] parameters = eleman.split(",");
            if (parameters[3].trim().equalsIgnoreCase("root")) {
                Director _director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                root = new TreeNode<Employee>(_director);
                rootDirector = _director;
                theRoot = parameters;
            }

            else {
                if (theRoot == null) {
                    theRoot = parameters;
                }
                if (parameters[3].trim().equalsIgnoreCase(theRoot[1].split(" ")[0].trim())) {
                    if (parameters[0].trim().equalsIgnoreCase("d")) {
                        Director _director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                        root.children.add(new TreeNode<Employee>(_director));
                        rootDirector.add(_director);

                    } else {
                        Officer _officer = new Officer(parameters[1], Integer.parseInt(parameters[2]));
                        root.children.add(new TreeNode<Employee>(_officer));
                        rootDirector.add(_officer);
                    }
                } else {
                    break;
                }
            }
        }
        int size = rootDirector.getChildren().size();
        for (int i = 0; i < size; i++) {
            if (rootDirector.getChildren().get(i).getClass() == Director.class) {
                Director element = (Director) rootDirector.getChildren().get(i);

                for (String parameter : list) {
                    String[] parameters = parameter.split(",");
                    if (element.getName().equals(parameters[3].trim())) {
                        if (parameters[0].toLowerCase().equalsIgnoreCase("d")) {

                            element.add(new Director(parameters[1], Integer.parseInt(parameters[2])));

                        } else {

                            element.add(new Officer(parameters[1], Integer.parseInt(parameters[2])));

                        }

                    }
                }
            }

        }
        return new EmployeeComposite(rootDirector);
    }

}
