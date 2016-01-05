package other;

public enum MyEnum {
    ENUM1 {
        public long toMicros(long d)  { return 2; }
    },
    ENUM2 {
        public long toNanos(long d)   { return 1; }
    };
    
    public long toMicros(long d)  { return 2; }
    
    public long toNanos(long d)  { return 2; }
}
