public enum VehicleSize {
    COMPACT(130),
    MIDSIZE(140),
    LARGE(160);

    /* Interior volume index */
    private final int volume;

    VehicleSize(int volume) {
        this.volume = volume;
    }

    public int volume() {
        return volume;
    }
}
