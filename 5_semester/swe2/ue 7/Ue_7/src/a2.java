class Garment {
    private GarmentType garmentType;

    double getNormalPrice() {
        return 20.0;
    }

    double getDiscount() {
        return 0.75;
    }

    double getPrice() {
        // return garmentType.getPrice() without this => strategy pattern
        return garmentType.getPrice(this);
    }
}

interface GarmentType {
    public double getPrice(Garment garment);
}

class GarmentNormal implements GarmentType {
    public double getPrice(Garment garment) {
        return garment.getNormalPrice();
    }
}

class GarmentSale implements GarmentType {
    public double getPrice(Garment garment) {
        return garment.getNormalPrice() * garment.getDiscount();
    }
}

class GarmentSuperSale implements GarmentType {
    public double getPrice(Garment garment) {
        return garment.getNormalPrice() * 0.5;
    }
}
