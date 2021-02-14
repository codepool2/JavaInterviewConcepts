package aroundclasses;

public interface EmailService {


    void sendEMail(EmailDetails emailDetails);


     class EmailDetails {

        private String name;
        private String to;

    }
}
