class Solution {
    public int maxTurbulenceSize(int[] arr) {
			int pre = 0;
		int len = 1;
		int ans = 1;
		for (int i = 1; i < arr.length; i++) {
			int c = Integer.compare(arr[i - 1], arr[i]);

			if (c == 0) {
				ans = Integer.max(ans, len);
				len = 1;
			} else {
				if (pre == 0 || pre + c == 0) {
					pre = c;
					ans = Integer.max(ans, ++len);
				} else {
					ans = Integer.max(ans, len);
					len = 2;
				}
			}
		}
        return ans;
    }
}