class Solution {

    public Map<Integer, String> numberWords;

    public String numberToWords(int num) {
        numberWords = new HashMap<>();
        numberWords.put(0, "Zero");
        numberWords.put(1, "One");
        numberWords.put(2, "Two");
        numberWords.put(3, "Three");
        numberWords.put(4, "Four");
        numberWords.put(5, "Five");
        numberWords.put(6, "Six");
        numberWords.put(7, "Seven");
        numberWords.put(8, "Eight");
        numberWords.put(9, "Nine");
        numberWords.put(10, "Ten");
        numberWords.put(11, "Eleven");
        numberWords.put(12, "Twelve");
        numberWords.put(13, "Thirteen");
        numberWords.put(14, "Fourteen");
        numberWords.put(15, "Fifteen");
        numberWords.put(16, "Sixteen");
        numberWords.put(17, "Seventeen");
        numberWords.put(18, "Eighteen");
        numberWords.put(19, "Nineteen");
        numberWords.put(20, "Twenty");
        numberWords.put(30, "Thirty");
        numberWords.put(40, "Forty");
        numberWords.put(50, "Fifty");
        numberWords.put(60, "Sixty");
        numberWords.put(70, "Seventy");
        numberWords.put(80, "Eighty");
        numberWords.put(90, "Ninety");
        numberWords.put(100, "Hundred");
        numberWords.put(1000, "Thousand");
        numberWords.put(1000000, "Million");
        numberWords.put(1000000000, "Billion");
    
        return convertToNumber(num, 1);
    }

    String convertToNumber(int num, int multiplier) {
        // last three;

        if (num == 0) {
            return multiplier == 1 ? "Zero" : "";
        }

        int number = num % 1000;
        String str = getNum(number);

        if (multiplier != 1 && !str.isEmpty()) {
            str += " " + numberWords.get(multiplier);
        }

        if (num / 1000 == 0) {
            return str.trim();
        }
    
        return convertToNumber(num / 1000, multiplier * 1000) + (str.isEmpty() ? "" : " ") + str;
    }

    String getNum(int num) {
        // not hundred;
        if (num / 100 == 0) {
            // not ten
            if (num / 10 == 0) {
                // handle only 0 to 9
                if (num == 0) return "";
                return numberWords.get(num);
            }
            // handle tens
            else {
                // handle till twenty
                if ((num % 100) <= 20) {
                    System.out.println("jmdedknmef");
                    return numberWords.get(num);
                } else {
                    int first = num % 10;
                    int last = ( num % 100 ) / 10;
                    if (first != 0) {
                        return numberWords.get(last*10) + " " + numberWords.get(first);
                    } else {
                        return numberWords.get(last*10);
                    }
                }
            }
        } else {
            int hundred = num / 100;
                
            if (num % 100 == 0 ){
                return numberWords.get(hundred) + " " + numberWords.get(100);
            }
                // not ten
            if (num / 10 == 0) {
                // handle only 0 to 9
                if (num % 10 == 0) return numberWords.get(hundred) + " " + numberWords.get(100) + " ";
                return numberWords.get(hundred) + " " + numberWords.get(100) + " " + numberWords.get(num % 10);
            }
            // handle tens
            else {
                // handle till twenty
                if ((num % 100) <= 20) {
                    return numberWords.get(hundred) + " " + numberWords.get(100) + " " + numberWords.get(num % 100);
                } else {
                    int first = num % 10;
                    int last = ( num % 100 ) / 10;
                    if (first != 0) {
                        return numberWords.get(hundred) + " " + numberWords.get(100) + " " + numberWords.get(last*10) + " " + numberWords.get(first);
                    } else {
                        return numberWords.get(hundred) + " " + numberWords.get(100) + " " +numberWords.get(last*10);
                    }
                }
            }

        }

    }
}