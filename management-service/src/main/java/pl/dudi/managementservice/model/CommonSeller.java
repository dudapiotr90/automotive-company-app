package pl.dudi.managementservice.model;

public class CommonSeller {
    public static Seller defaultSeller() {
        return Seller.builder()
            .nip("012 345 6789")
            .companyName("Automotive App")
            .phoneNumber("+48 123 456 789")
            .email("piotrjavatestowy@gmail.com")
            .build();
    }

}
