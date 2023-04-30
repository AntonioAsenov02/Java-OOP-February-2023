package Exercise2_Encapsulation.P01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length < 1){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width < 1){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height < 1){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea(){
        return  2 * (getLength() * getWidth()) + 2 * (getLength() * getHeight()) + 2 * (getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea(){
        return 2 * (getLength() * getHeight()) + 2 * (getWidth() * getHeight());
    }

    public double calculateVolume(){
        return getLength() * getWidth() * getHeight();
    }
}
