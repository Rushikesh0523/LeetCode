class MyCalendar {
    // List to store all the booked events
    private List<int[]> bookings;

    // Constructor to initialize the list
    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    // Method to book an event
    public boolean book(int start, int end) {
        // Check for overlaps with the existing bookings
        for (int[] booking : bookings) {
            int s = booking[0];
            int e = booking[1];
            // If there is an overlap, return false
            if (start < e && end > s) {
                return false;
            }
        }
        // If no overlap, add the booking and return true
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */