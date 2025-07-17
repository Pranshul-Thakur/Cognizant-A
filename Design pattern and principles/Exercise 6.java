public class ProxyPatternExample {

    interface Image {
        void display();
    }

    class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        ProxyPatternExample app = new ProxyPatternExample();

        Image img1 = app.new ProxyImage("cat.png");
        Image img2 = app.new ProxyImage("dog.png");

        img1.display();
        img1.display();
        img2.display();
    }
}
