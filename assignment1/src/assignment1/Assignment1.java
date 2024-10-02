package assignment1;

import java.util.Scanner;

public class Assignment1 {

    node stdHead;
    node cHead;

    public Assignment1() {
    }

    class node {

        int id;
        String stdName;
        String cName;
        node firnext;
        node secnext;

        public node(int id, String stdName, String cName) {
            this.id = id;
            this.stdName = stdName;
            this.cName = cName;
        }

        public node() {
            id = 0;
            stdName = null;
            cName = null;
            firnext = null;
            secnext = null;
        }

        public node(int id, String stdName) {
            this.id = id;
            this.stdName = stdName;
        }

        public node(int id, String stdName, node firnext) {
            this.id = id;
            this.stdName = stdName;
            this.firnext = firnext;
        }

        public node(String cName, node firnext) {
            this.cName = cName;
            this.firnext = firnext;
        }

        public node(String cName) {
            this.cName = cName;
        }

    }

    //node std = new node(1, "ali");
    //node cours = new node("math");
    @SuppressWarnings("empty-statement")
    public void addStd(int Id, String stdName) {
        node tmp = new node();
        if (stdHead == null) {
            stdHead = new node(Id, stdName);
        } else {
            //stdHead.firnext = new node(id, stdName, std);
            for (tmp = stdHead; tmp.firnext != null;) {
                tmp = tmp.firnext;
            }
            tmp.firnext = new node(Id, stdName);

        }
    }

    @SuppressWarnings("empty-statement")
    public void addC(String cName) {
        node tmp;
        if (cHead == null) {
            cHead = new node(cName);
        } else {
            //cHead.firnext = new node(cName, cours);
            for (tmp = cHead; tmp.secnext != null;) {
                tmp = tmp.secnext;
            }
            tmp.secnext = new node(cName);

        }
    }

    public void deleteStd(int id) {
        node temp, tmp;
        node x = searchStd(id);
        temp = x;
        while (temp.secnext != null) {
            temp.secnext.cName = "canceled Student";
            temp = temp.secnext;
        }
        if (stdHead == x) {
            stdHead = stdHead.firnext;
        } else {
            node tmp1;
            node tmp2 = stdHead.firnext;
            for (tmp1 = stdHead; tmp2 != x;) {
                tmp1 = tmp1.firnext;
                tmp2 = tmp2.firnext;
            }
            tmp1.firnext = tmp2.firnext;
        }
        //for (tmp = stdHead; tmp.firnext != null && !(tmp.firnext.id == id); tmp = tmp.firnext);

    }

    public void deleteC(String cname) {
        node temp;
        node x = searchC(cname);
        temp = x;
        while (temp.firnext != null) {
            temp.firnext.cName = "canceled course";
            temp = temp.firnext;
        }
        if (cHead == x) {
            cHead = cHead.secnext;
        } else {
            node tmp;
            node tmp2 = cHead.secnext;
            for (tmp = cHead; tmp2 != x;) {
                tmp = tmp.secnext;
                tmp2 = tmp2.secnext;
            }
            tmp.secnext = tmp2.secnext;
        }
    }

    @SuppressWarnings("empty-statement")
    public node searchStd(int id) {
        node tmp;
        for (tmp = stdHead; tmp != null && !(tmp.id == id); tmp = tmp.firnext);
        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }
    }

    @SuppressWarnings("empty-statement")
    public node searchStdName(String name) {
        node tmp;
        for (tmp = stdHead; tmp != null && !(tmp.stdName.equals(name)); tmp = tmp.firnext);
        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }
    }

    @SuppressWarnings("empty-statement")
    public node searchC(String name) {
        node tmp;
        for (tmp = cHead; tmp != null && !(tmp.cName.equals(name)); tmp = tmp.secnext);
        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }
    }

    public void printStdDtails(int id) {
        node tmp = searchStd(id);
        System.out.println("Student ID  " + tmp.id + "  Student Name " + tmp.stdName);
        while (tmp.secnext != null) {
            System.out.println(tmp.secnext.cName);
            tmp = tmp.secnext;
        }
    }

    public void printCDtails(String name) {
        node tmp = searchC(name);
        System.out.println("Course Name " + tmp.cName);
        while (tmp.firnext != null) {
            System.out.println(tmp.firnext.stdName);
            tmp = tmp.firnext;
        }
    }

    @SuppressWarnings("empty-statement")
    public void enroll(int id, String cname, String stdName) {
        node x = searchStd(id);
        node z = searchC(cname);

        node tmp, tmpc;
        if ((x == null) || (z == null)) {
            System.out.println("invalid enroll input please try again");
        } else {
            // Create a new node for the enrollment
            node newNode = new node(id, stdName, cname);

            // Link the new node to the student node
            for (tmp = x; tmp.secnext != null; tmp = tmp.secnext);
            tmp.secnext = newNode;

            // Link the new node to the course node
            for (tmpc = z; tmpc.firnext != null; tmpc = tmpc.firnext);
            tmpc.firnext = newNode;
        }
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        Assignment1 b1 = new Assignment1();
        b1.addStd(1, "ali");
        b1.addC("math");
        //node s=b1.searchC("math");
        //b1.printCDtails("math");
        // System.out.println(s);
        System.out.println("Enter 1 for add new Student");
        System.out.println("Enter 2 for add new course");
        System.out.println("Enter 3 for enroll course to student");
        System.out.println("Enter 4 for delete student");
        System.out.println("Enter 5 for delete course");
        System.out.println("Enter 6 for print student's details");
        System.out.println("Enter 7 for print course's details");
        System.out.println("Enter 8 for Exit");
        int a = k.nextInt();
        OUTER:
        while (a != 8) {
            switch (a) {
                case 1: {
                    System.out.println("please enter his Id");
                    int id = k.nextInt();
                    node l = b1.searchStd(id);
                    while (b1.searchStd(id) != null) {
                        System.out.println("this id is already exist please try again");
                        System.out.println("please enter his id");
                        id = k.nextInt();
                    }
                    System.out.println("please enter his name");
                    String stdname = k.next();
                    b1.addStd(id, stdname);
                    break;
                }
                case 2: {
                    System.out.println("please enter course name");
                    String name = k.next();
                    while (b1.searchC(name) != null) {
                        System.out.println("this course is already exist please try again");
                        name = k.next();
                    }
                    b1.addC(name);
                    break;
                }
                case 3: {
                    System.out.println("please enter Studnt's ID");
                    int id = k.nextInt();
                    while (b1.searchStd(id) == null) {
                        System.out.println("this id is not exist please try again");
                        System.out.println("please enter his id");
                        id = k.nextInt();
                    }
                    System.out.println("please enter his name");
                    String name = k.next();
                    while (b1.searchStdName(name) == null) {
                        System.out.println("this name is not exist please try again");
                        System.out.println("please enter his name");
                        name = k.next();
                    }
                    System.out.println("please enter the course");
                    String cname = k.next();
                    while (b1.searchC(cname) == null) {
                        System.out.println("this cours is not exist please try again");
                        System.out.println("please enter cours name");
                        cname = k.next();
                    }
                    b1.enroll(id, cname, name);
                    break;
                }
                case 4: {
                    System.out.println("please enter Studnt's ID");
                    int id = k.nextInt();
                    while (b1.searchStd(id) == null) {
                        System.out.println("this id is not exist please try again");
                        System.out.println("please enter his id");
                        id = k.nextInt();
                    }
                    b1.deleteStd(id);
                    break;
                }
                case 5: {
                    System.out.println("please enter the course");
                    String cname = k.next();
                    while (b1.searchC(cname) == null) {
                        System.out.println("this course is not exist please try again");
                        System.out.println("please enter the course");
                        cname = k.next();
                    }
                    b1.deleteC(cname);
                    break;
                }
                case 6: {
                    System.out.println("please enter Studnt's ID");
                    int id = k.nextInt();
                    while (b1.searchStd(id) == null) {
                        System.out.println("this id is not exist please try again");
                        System.out.println("please enter his id");
                        id = k.nextInt();
                    }
                    b1.printStdDtails(id);
                    break;
                }
                case 7: {
                    System.out.println("please enter the course");
                    String cname = k.next();
                    while (b1.searchC(cname) == null) {
                        System.out.println("this course is not exist please try again");
                        System.out.println("please enter his name");
                        cname = k.next();
                    }
                    b1.printCDtails(cname);
                    break;
                }
                case 8:
                    break OUTER;
                default:
                    System.out.println("invalid input please try again");
                    break;
            }
            System.out.println("Enter 1 for add new Student");
            System.out.println("Enter 2 for add new course");
            System.out.println("Enter 3 for enroll course to student");
            System.out.println("Enter 4 for delete student");
            System.out.println("Enter 5 for delete course");
            System.out.println("Enter 6 for print student's details");
            System.out.println("Enter 7 for print course's details");
            System.out.println("Enter 8 for Exit");
            a = k.nextInt();
        }
    }

}
