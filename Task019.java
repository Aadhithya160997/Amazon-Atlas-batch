public enum Task019 {
        public static void main(String[] args) {
            // Print all elements
            for(Element e : Element.values()) {
                System.out.printf("%s: %s (Atomic number: %d, Weight: %.4f)%n",
                        e.name(), e.label, e.atomicNumber, e.atomicWeight);
            }

            // Example searches
            System.out.println("\nFound: " + Element.valueOfLabel("Hydrogen"));
            System.out.println("Found: " + Element.valueOfAtomicNumber(2));
            System.out.println("Found: " + Element.valueOfAtomicWeight(20.180f));
        }
    }

