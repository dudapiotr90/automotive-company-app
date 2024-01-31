package pl.dudi.emailservice.model.emailtemplates;

public interface IssuedOrderEmailTemplate {
    String emailBody = """
        Email body after issuing an order
        """;
    String emailSubject = "Issued order confirmation";
}
