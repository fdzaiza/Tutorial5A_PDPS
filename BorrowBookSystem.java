import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// ============ MAIN MENU ============
public class BorrowBookSystem extends JFrame {
    // lists to keep all student and book objects
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<Book> bookList = new ArrayList<Book>();

    private JLabel label1;
    private JButton btnAddStudent;
    private JButton btnAddBook;
    private JButton btnBorrowBook;

    public BorrowBookSystem() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1));

        label1 = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrowBook = new JButton("Borrow Book");

        pane.add(label1);
        pane.add(btnAddStudent);
        pane.add(btnAddBook);
        pane.add(btnBorrowBook);

        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudentFrame frame = new AddStudentFrame();
                frame.setVisible(true);
            }
        });

        btnAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddBookFrame frame = new AddBookFrame();
                frame.setVisible(true);
            }
        });

        btnBorrowBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorrowBookFrame frame = new BorrowBookFrame();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        BorrowBookSystem frame = new BorrowBookSystem();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Menu");
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}

// ============ STUDENT CLASS ============
class Student {
    private String name;
    private String matric;

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }

    public String getName() {
        return name;
    }

    public String getMatric() {
        return matric;
    }

    public String toString() {
        return name + " (" + matric + ")";
    }
}

// ============ BOOK CLASS ============
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String borrowBy(Student s) {
        return s.getName() + " with matric number " + s.getMatric()
                + " has borrow a book with title " + title + ".";
    }

    public String toString() {
        return title + " (" + author + ")";
    }
}

// ============ ADD STUDENT INFO ============
class AddStudentFrame extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnAdd;
    private JButton btnList;
    private JTextArea textArea1;

    public AddStudentFrame() {
        setTitle("Add Student Info");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(0, 0));

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel(new BorderLayout());
        JPanel p4 = new JPanel(new BorderLayout());

        label1 = new JLabel("Name:");
        label2 = new JLabel("Matric:");
        label3 = new JLabel("Students:");
        textField1 = new JTextField();
        textField2 = new JTextField();
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        textArea1 = new JTextArea();

        p1.add(label1);
        p1.add(textField1);
        p1.add(label2);
        p1.add(textField2);

        p2.add(btnAdd);
        p2.add(btnList);

        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.CENTER);

        p4.add(label3, BorderLayout.NORTH);
        p4.add(new JScrollPane(textArea1), BorderLayout.CENTER);

        pane.add(p3, BorderLayout.NORTH);
        pane.add(p4, BorderLayout.CENTER);

        // Add button: create a Student object and save it
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = new Student(textField1.getText(), textField2.getText());
                BorrowBookSystem.studentList.add(s);
                textField1.setText("");
                textField2.setText("");
            }
        });

        // List button: show all students
        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                for (Student s : BorrowBookSystem.studentList) {
                    textArea1.append("Name : " + s + "\n");
                }
            }
        });
    }
}

// ============ ADD BOOK INFO ============
class AddBookFrame extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnAdd;
    private JButton btnList;
    private JTextArea textArea1;

    public AddBookFrame() {
        setTitle("Add Book Info");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(0, 0));

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel(new BorderLayout());
        JPanel p4 = new JPanel(new BorderLayout());

        label1 = new JLabel("Book Title:");
        label2 = new JLabel("Author:");
        label3 = new JLabel("Books:");
        textField1 = new JTextField();
        textField2 = new JTextField();
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        textArea1 = new JTextArea();

        p1.add(label1);
        p1.add(textField1);
        p1.add(label2);
        p1.add(textField2);

        p2.add(btnAdd);
        p2.add(btnList);

        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.CENTER);

        p4.add(label3, BorderLayout.NORTH);
        p4.add(new JScrollPane(textArea1), BorderLayout.CENTER);

        pane.add(p3, BorderLayout.NORTH);
        pane.add(p4, BorderLayout.CENTER);

        // Add button: create a Book object and save it
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book b = new Book(textField1.getText(), textField2.getText());
                BorrowBookSystem.bookList.add(b);
                textField1.setText("");
                textField2.setText("");
            }
        });

        // List button: show all books
        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                for (Book b : BorrowBookSystem.bookList) {
                    textArea1.append("Book title : " + b.getTitle()
                            + " (Author : " + b.getAuthor() + ")\n");
                }
            }
        });
    }
}

// ============ BORROW BOOK ============
class BorrowBookFrame extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel lblResult;
    private JComboBox<Student> comboStudent;
    private JComboBox<Book> comboBook;
    private JButton btnBorrow;

    public BorrowBookFrame() {
        setTitle("Borrow Book");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(0, 0));

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel(new GridLayout(2, 1));

        label1 = new JLabel("Student Name & Matric:");
        label2 = new JLabel("Book Title & Author:");
        label3 = new JLabel("Borrow Information :");
        lblResult = new JLabel("");
        comboStudent = new JComboBox<Student>();
        comboBook = new JComboBox<Book>();
        btnBorrow = new JButton("Borrow");

        // put the saved objects into the combo boxes
        for (Student s : BorrowBookSystem.studentList) {
            comboStudent.addItem(s);
        }
        for (Book b : BorrowBookSystem.bookList) {
            comboBook.addItem(b);
        }

        p1.add(label1);
        p1.add(comboStudent);
        p1.add(label2);
        p1.add(comboBook);

        p2.add(btnBorrow);

        p3.add(label3);
        p3.add(lblResult);

        pane.add(p1, BorderLayout.NORTH);
        pane.add(p2, BorderLayout.CENTER);
        pane.add(p3, BorderLayout.SOUTH);

        // Borrow button: show the borrow message
        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = (Student) comboStudent.getSelectedItem();
                Book b = (Book) comboBook.getSelectedItem();

                if (s == null || b == null) {
                    lblResult.setText("Please add student and book info first.");
                } else {
                    lblResult.setText(b.borrowBy(s));
                }
            }
        });
    }
}
