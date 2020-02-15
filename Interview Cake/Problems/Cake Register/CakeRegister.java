public class CakeRegister {
    public boolean isQueue(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        if (takeOutOrders = null || takeOutOrders.length == 0) {
            return isQueue(dineInOrders, servedOrders);
        } else if (dineInOrders == null || dineInOrders.length == 0) {
            return isQueue(takeOutOrders, servedOrders);
        } else if (takeOutOrders.length + dineInOrders.length != servedOrders.length) {
            return false;
        }

        int takeOutIndex = 0;
        int dineInIndex = 0;

        for (int servedOrder: servedOrders) {
            boolean equalsTakeOutOrder = takeOutIndex < takeOutOrders.length &&
                    servedOrder == takeOutOrders[takeOutIndex];
            boolean equalsDineInOrder = dineInIndex < dineInOrders.length &&
                    servedOrder == dineInOrders[dineInIndex];

            if (equalsTakeOutOrder) {
                takeOutIndex++;
            } else if (equalsDineInOrder) {
                dineInIndex++;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isQueue(int[] arr, int[] merged) {
        if (arr == null || merged == null) return false;
        if (arr.length != merged.length) return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != merged[i]) {
                return false;
            }
        }
    }
}