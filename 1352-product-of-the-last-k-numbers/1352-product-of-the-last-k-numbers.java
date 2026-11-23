class ProductOfNumbers {

    ArrayList<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1);
        } else {
            int last = products.get(products.size() - 1);
            products.add(last * num);
        }
    }

    public int getProduct(int k) {
        if (k >= products.size()) {
            return 0;
        }

        int n = products.size();
        return products.get(n - 1) / products.get(n - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */