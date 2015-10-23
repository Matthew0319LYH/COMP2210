% A5 Lab Report
% Xing Wang
% October 24, 2015

# Benchmarking the ArrayStrand implementation

## Show that ArrayStrand.cutAndSplice() is O(N)

DNA length = 4639221
Restiction enzyme = gaattc

ArrayStrand:     splice length                    256    time    0.105 recombinant length            4,800,471
ArrayStrand:     splice length                    512    time    0.094 recombinant length            4,965,591
ArrayStrand:     splice length                  1,024    time    0.068 recombinant length            5,295,831
ArrayStrand:     splice length                  2,048    time    0.047 recombinant length            5,956,311
ArrayStrand:     splice length                  4,096    time    0.062 recombinant length            7,277,271
ArrayStrand:     splice length                  8,192    time    0.063 recombinant length            9,919,191
ArrayStrand:     splice length                 16,384    time    0.109 recombinant length           15,203,031
ArrayStrand:     splice length                 32,768    time    0.094 recombinant length           25,770,711
ArrayStrand:     splice length                 65,536    time    0.188 recombinant length           46,906,071
ArrayStrand:     splice length                131,072    time    0.406 recombinant length           89,176,791
ArrayStrand:     splice length                262,144    time    0.852 recombinant length          173,718,231
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.expandCapacity(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at ArrayStrand.cutAndSplice(ArrayStrand.java:75)
        at DNASimulation.getCutAndSpliceTime(DNASimulation.java:88)
        at DNASimulation.main(DNASimulation.java:52)
		
		
## Determine the largest power-of-two splice supported with 512M heap

DNA length = 4639221
Restiction enzyme = gaattc

ArrayStrand:     splice length                    256    time    0.101 recombinant length            4,800,471
ArrayStrand:     splice length                    512    time    0.054 recombinant length            4,965,591
ArrayStrand:     splice length                  1,024    time    0.046 recombinant length            5,295,831
ArrayStrand:     splice length                  2,048    time    0.047 recombinant length            5,956,311
ArrayStrand:     splice length                  4,096    time    0.047 recombinant length            7,277,271
ArrayStrand:     splice length                  8,192    time    0.078 recombinant length            9,919,191
ArrayStrand:     splice length                 16,384    time    0.110 recombinant length           15,203,031
ArrayStrand:     splice length                 32,768    time    0.125 recombinant length           25,770,711
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOfRange(Unknown Source)
        at java.lang.String.<init>(Unknown Source)
        at java.lang.String.substring(Unknown Source)
        at java.lang.String.trim(Unknown Source)
        at ArrayStrand.cutAndSplice(ArrayStrand.java:78)
        at DNASimulation.getCutAndSpliceTime(DNASimulation.java:88)
        at DNASimulation.main(DNASimulation.java:52)

## Determine the largest power-of-two splice supported with 1024M heap

DNA length = 4639221
Restiction enzyme = gaattc

ArrayStrand:     splice length                    256    time    0.094 recombinant length            4,800,471
ArrayStrand:     splice length                    512    time    0.062 recombinant length            4,965,591
ArrayStrand:     splice length                  1,024    time    0.047 recombinant length            5,295,831
ArrayStrand:     splice length                  2,048    time    0.047 recombinant length            5,956,311
ArrayStrand:     splice length                  4,096    time    0.047 recombinant length            7,277,271
ArrayStrand:     splice length                  8,192    time    0.047 recombinant length            9,919,191
ArrayStrand:     splice length                 16,384    time    0.078 recombinant length           15,203,031
ArrayStrand:     splice length                 32,768    time    0.109 recombinant length           25,770,711
ArrayStrand:     splice length                 65,536    time    0.235 recombinant length           46,906,071
ArrayStrand:     splice length                131,072    time    0.343 recombinant length           89,176,791
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.expandCapacity(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at ArrayStrand.cutAndSplice(ArrayStrand.java:75)
        at DNASimulation.getCutAndSpliceTime(DNASimulation.java:88)
        at DNASimulation.main(DNASimulation.java:52)

## Determine the largest power-of-two splice supported as heap doubles

DNA length = 4639221
Restiction enzyme = gaattc

ArrayStrand:     splice length                    256    time    0.105 recombinant length            4,800,471
ArrayStrand:     splice length                    512    time    0.094 recombinant length            4,965,591
ArrayStrand:     splice length                  1,024    time    0.068 recombinant length            5,295,831
ArrayStrand:     splice length                  2,048    time    0.047 recombinant length            5,956,311
ArrayStrand:     splice length                  4,096    time    0.062 recombinant length            7,277,271
ArrayStrand:     splice length                  8,192    time    0.063 recombinant length            9,919,191
ArrayStrand:     splice length                 16,384    time    0.109 recombinant length           15,203,031
ArrayStrand:     splice length                 32,768    time    0.094 recombinant length           25,770,711
ArrayStrand:     splice length                 65,536    time    0.188 recombinant length           46,906,071
ArrayStrand:     splice length                131,072    time    0.406 recombinant length           89,176,791
ArrayStrand:     splice length                262,144    time    0.852 recombinant length          173,718,231
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.expandCapacity(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at ArrayStrand.cutAndSplice(ArrayStrand.java:75)
        at DNASimulation.getCutAndSpliceTime(DNASimulation.java:88)
        at DNASimulation.main(DNASimulation.java:52)
		
# Verifying the LinkedStrand implementation

## Show that LinkedStrand.cutAndSplice() is O(1)
Record your response here.

## Determine the largest power-of-two splice supported with 512M heap

DNA length = 4639221
Restiction enzyme = gaattc

LinkedStrand:    splice length                    256    time    0.922 recombinant length            4,800,471
LinkedStrand:    splice length                    512    time    0.862 recombinant length            4,965,591
LinkedStrand:    splice length                  1,024    time    0.875 recombinant length            5,295,831
LinkedStrand:    splice length                  2,048    time    0.890 recombinant length            5,956,311
LinkedStrand:    splice length                  4,096    time    0.860 recombinant length            7,277,271
LinkedStrand:    splice length                  8,192    time    0.848 recombinant length            9,919,191
LinkedStrand:    splice length                 16,384    time    0.859 recombinant length           15,203,031
LinkedStrand:    splice length                 32,768    time    0.844 recombinant length           25,770,711
LinkedStrand:    splice length                 65,536    time    0.859 recombinant length           46,906,071
LinkedStrand:    splice length                131,072    time    0.860 recombinant length           89,176,791
LinkedStrand:    splice length                262,144    time    0.859 recombinant length          173,718,231
LinkedStrand:    splice length                524,288    time    0.875 recombinant length          342,801,111
LinkedStrand:    splice length              1,048,576    time    0.890 recombinant length          680,966,871
LinkedStrand:    splice length              2,097,152    time    0.875 recombinant length        1,357,298,391
LinkedStrand:    splice length              4,194,304    time    0.875 recombinant length        2,709,961,431
LinkedStrand:    splice length              8,388,608    time    0.875 recombinant length        5,415,287,511
LinkedStrand:    splice length             16,777,216    time    0.938 recombinant length       10,825,939,671
LinkedStrand:    splice length             33,554,432    time    0.901 recombinant length       21,647,243,991
LinkedStrand:    splice length             67,108,864    time    0.860 recombinant length       43,289,852,631
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.expandCapacity(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at DNASimulation.main(DNASimulation.java:49)

## Determine the largest power-of-two splice supported with 1024M heap

DNA length = 4639221
Restiction enzyme = gaattc

LinkedStrand:    splice length                    256    time    0.841 recombinant length            4,800,471
LinkedStrand:    splice length                    512    time    0.752 recombinant length            4,965,591
LinkedStrand:    splice length                  1,024    time    0.751 recombinant length            5,295,831
LinkedStrand:    splice length                  2,048    time    0.750 recombinant length            5,956,311
LinkedStrand:    splice length                  4,096    time    0.765 recombinant length            7,277,271
LinkedStrand:    splice length                  8,192    time    0.750 recombinant length            9,919,191
LinkedStrand:    splice length                 16,384    time    0.734 recombinant length           15,203,031
LinkedStrand:    splice length                 32,768    time    0.750 recombinant length           25,770,711
LinkedStrand:    splice length                 65,536    time    0.750 recombinant length           46,906,071
LinkedStrand:    splice length                131,072    time    0.750 recombinant length           89,176,791
LinkedStrand:    splice length                262,144    time    0.760 recombinant length          173,718,231
LinkedStrand:    splice length                524,288    time    0.797 recombinant length          342,801,111
LinkedStrand:    splice length              1,048,576    time    0.802 recombinant length          680,966,871
LinkedStrand:    splice length              2,097,152    time    0.757 recombinant length        1,357,298,391
LinkedStrand:    splice length              4,194,304    time    0.760 recombinant length        2,709,961,431
LinkedStrand:    splice length              8,388,608    time    0.750 recombinant length        5,415,287,511
LinkedStrand:    splice length             16,777,216    time    0.766 recombinant length       10,825,939,671
LinkedStrand:    splice length             33,554,432    time    0.781 recombinant length       21,647,243,991
LinkedStrand:    splice length             67,108,864    time    0.859 recombinant length       43,289,852,631
LinkedStrand:    splice length            134,217,728    time    0.827 recombinant length       86,575,069,911
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.expandCapacity(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at DNASimulation.main(DNASimulation.java:49)

## Determine the largest power-of-two splice supported as heap doubles

DNA length = 4639221
Restiction enzyme = gaattc

LinkedStrand:    splice length                    256    time    0.874 recombinant length            4,800,471
LinkedStrand:    splice length                    512    time    0.726 recombinant length            4,965,591
LinkedStrand:    splice length                  1,024    time    0.783 recombinant length            5,295,831
LinkedStrand:    splice length                  2,048    time    0.691 recombinant length            5,956,311
LinkedStrand:    splice length                  4,096    time    0.719 recombinant length            7,277,271
LinkedStrand:    splice length                  8,192    time    0.718 recombinant length            9,919,191
LinkedStrand:    splice length                 16,384    time    0.710 recombinant length           15,203,031
LinkedStrand:    splice length                 32,768    time    0.686 recombinant length           25,770,711
LinkedStrand:    splice length                 65,536    time    0.714 recombinant length           46,906,071
LinkedStrand:    splice length                131,072    time    0.704 recombinant length           89,176,791
LinkedStrand:    splice length                262,144    time    0.708 recombinant length          173,718,231
LinkedStrand:    splice length                524,288    time    0.713 recombinant length          342,801,111
LinkedStrand:    splice length              1,048,576    time    0.703 recombinant length          680,966,871
LinkedStrand:    splice length              2,097,152    time    0.703 recombinant length        1,357,298,391
LinkedStrand:    splice length              4,194,304    time    0.703 recombinant length        2,709,961,431
LinkedStrand:    splice length              8,388,608    time    0.721 recombinant length        5,415,287,511
LinkedStrand:    splice length             16,777,216    time    0.742 recombinant length       10,825,939,671
LinkedStrand:    splice length             33,554,432    time    0.749 recombinant length       21,647,243,991
LinkedStrand:    splice length             67,108,864    time    0.792 recombinant length       43,289,852,631
LinkedStrand:    splice length            134,217,728    time    0.864 recombinant length       86,575,069,911
LinkedStrand:    splice length            268,435,456    time    0.995 recombinant length      173,145,504,471
LinkedStrand:    splice length            536,870,912    time    0.964 recombinant length      346,286,373,591
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.expandCapacity(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at DNASimulation.main(DNASimulation.java:49)
