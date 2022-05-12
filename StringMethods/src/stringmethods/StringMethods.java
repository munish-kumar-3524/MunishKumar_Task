/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringmethods;
import java.io.*;
import java.util.*;

/**
 *
 * @author Munish kumar
 */
public class StringMethods {

    final static Scanner SC = new Scanner(System.in);
    final static InputStreamReader ISR = new InputStreamReader(System.in);
    final static BufferedReader BR = new BufferedReader(ISR);
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        boolean check = true;
        while(check){
            System.out.print("""
                               1.charAt()\t2.codePointAt()\t3.codePointBefore()\t4.codePointCount()\t5.compareTo()\t6.compareToIgnoreCase()\t7.contains()\t8.concat()
                               9.contentEquals()\t10.copyValueOf()\t11.endsWith()\t12.equals()\t13.equalsIgnoreCase()\t14.format()\t15.getBytes()\t16.getChars()
                               17.hashCode()\t18.indexOf()\t19.intern()\t20.isEmpty()\t21.lastIndexOf()\t22.length()\t23.matches()\t24.offsetByCodePoints()
                               25.regionMatches()\t26.replace()\t27.replaceFirst()\t28.replaceAll()\t29.split()\t30.startsWith()\t31.subSequence()\t32.subString()
                               33.toCharArray()\t34.toLowerCase()\t35.toString()\t36.toUpperCase()\t37.trim()\t38.valueOf()
                               """);
            System.out.print("Enter your choice : ");
            int ch = SC.nextInt();
            switch(ch){
                case 1 -> charAt();
                case 2 -> codePointAt();
                case 3 -> codePointBefore();
                case 4 -> codePointCount();
                case 5 -> compareTo();
                case 6 -> compareToIgnoreCase();
                case 7 -> contains();
                case 8 -> concat();
                case 9 -> contentEquals();
                case 10 -> copyValueOf();
                case 11 -> endsWith();
                case 12 -> equals();
                case 13 -> equalsIgnoreCase();
                case 14 -> format();
                case 15 -> getBytes();
                case 16 -> getChars();
                case 17 -> hash_Code();
                case 18 -> indexOf();
                case 19 -> intern();
                case 20 -> isEmpty();
                case 21 -> lastIndexOf();
                case 22 -> length();
                case 23 -> match();
                case 24 -> offsetByCodePoints();
                case 25 -> regionMatches();
                case 26 -> replace();
                case 27 -> replaceFirst();
                case 28 -> replaceAll();
                case 29 -> split();
                case 30 -> startsWith();
                case 31 -> subSequence();
                case 32 -> subString();
                case 33 -> toCharArray();
                case 34 -> toLowerCase();
                case 35 -> to_String();
                case 36 -> toUpperCase();
                case 37 -> trim();
                case 38 -> valueOf();
            }
            System.out.println("Do you want to continue (yes = 1/ No = 0) : ");
            ch = SC.nextInt();
            if(ch == 0) check = false;
        }
    }

    private static void charAt() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the index : ");
        int index;
        index = SC.nextInt();
        if(index < 0 || index > count-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.println(charArr[index]);
    }

    private static void codePointAt() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the index : ");
        int index;
        index = SC.nextInt();
        if(index < 0 || index > count-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.println((int)charArr[index]);
    }

    private static void codePointBefore() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the index : ");
        int index;
        index = SC.nextInt();
        if(index < 1 || index > count-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.println((int)charArr[index]);
    }

    private static void codePointCount() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the first index : ");
        int first;
        first = SC.nextInt();
        if(first < 0){
            System.out.println("Index out of bound");
            return;
        }
        System.out.print("Enter the last index : ");
        int last;
        last = SC.nextInt();
        if(last > count-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.println(last - first);
    }

    private static void compareTo() throws IOException {
        System.out.print("Enter the first string : ");
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            count1 = count1+i;
        }
        
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            count2 = count2+i;
        }
        
        if(count1 == count2) System.out.println(0);
        else if(count1 < count2) System.out.println(count1-count2);
        else System.out.println(count2-count1);
    }

    private static void compareToIgnoreCase() throws IOException {
        System.out.print("Enter the first string : ");
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            if(i>=97 && i<=122) i = i-32;
            count1 = count1+i;
        }
        
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            if(i>=97 && i<=122) i = i-32;
            count2 = count2+i;
        }
        
        if(count1 == count2) System.out.println("0");
        else if(count1 < count2) System.out.println("-1");
        else System.out.println("1");
    }

    private static void contains() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        boolean check = false;
        for(i=0;i<count1;i++){
            if(charArray2[0] == charArray1[i]){
                int j;
                for(j=0;j<count2;j++){
                    if(charArray2[j] != charArray1[i+j])
                        break;
                }
                if(j == count2) check = true;
            }
        }
        System.out.println(check);
    }

    private static void concat() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        
        char charArray[] = new char[count1 + count2];
        for(i=0;i<count1;i++) charArray[i] = (char) list1.receiveData(i);
        for(i=count1;i<count1+count2;i++) charArray[i] = (char) list2.receiveData(i-count1);
        System.out.println(charArray);
    }

    private static void contentEquals() throws IOException {
        System.out.print("Enter the string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter a Characer sequence : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        String tempString = "";
        for(i=0;i<count2;i++) tempString += (char) list2.receiveData(i);
        CharSequence charSeq = tempString;
        
        System.out.print("Enter a StringBuffer : ");
        StringBuffer stringBuff = new StringBuffer();
        SC.nextLine();
        stringBuff.append(SC.nextLine());

        boolean check1 = true, check2 = true;
        if(count1 == stringBuff.length()){
            for(i=0;i<count1;i++){
                if(charArray1[i] != stringBuff.charAt(i)) check1 = false;
            }
        }else check1 = false;
        
        if(count1 == charSeq.length()){
            for(i=0;i<count1;i++){
                if(charArray1[i] != charSeq.charAt(i)) check2 = false;
            }
        }else check2 = false;
        
        System.out.print("The String and StringBuffer is : ");
        if(check1) System.out.println("Equal");
        else System.out.println("Not Equal");
        
        System.out.print("The String and CharacterSequence is : ");
        if(check2) System.out.println("Equal");
        else System.out.println("Not Equal");
    }

    private static void copyValueOf() throws IOException {
        System.out.print("Enter the size of the array : ");
        int n = SC.nextInt();
        System.out.print("Enter the elements : ");
        LinkList list1 = new LinkList();
        int i;
        while((i = BR.read())!='\n'){
            if(i == ' ') continue;
            list1.insertData(i);
        }
        char charArray[] = new char[n];
        for(i=0;i<n;i++) charArray[i] = (char) list1.receiveData(i);
        int firstIndex, lastIndex;
        System.out.print("Enter the first index : ");
        firstIndex = SC.nextInt();
        if(firstIndex < 0){
            System.out.println("Index out of bound");
            return;
        }
        System.out.print("Enter the last index : ");
        lastIndex = SC.nextInt();
        if(lastIndex > n-1){
            System.out.println("Index out of bound");
            return;
        }
        String tempString = "";
        
        for(i=firstIndex;i<lastIndex;i++) tempString = tempString+charArray[i];
        System.out.println(tempString);
    }

    private static void endsWith() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        boolean check = true;
        if(count1 > count2){
            int j = count2-1;
            for(i=count1-1;i>=count1-count2;i--){
                if(charArray1[i] != charArray2[j--]) check = false;
            }
        }else check = false;
        System.out.println(check);
    }

    private static void equals() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        boolean check = true;
        if(count1 == count2){
            for(i=0;i<count1;i++){
                if(charArray1[i] != charArray2[i]) check = false;
            }
        }else check = false;
        System.out.println(check);
    }

    private static void equalsIgnoreCase() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            if(i>=97 && i<=122) i = i-32;
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            if(i>=97 && i<=122) i = i-32;
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        boolean check = true;
        if(count1 == count2){
            for(i=0;i<count1;i++){
                if(charArray1[i] != charArray2[i]) check = false;
            }
        }else check = false;
        System.out.println(check);
    }

    private static void format() throws IOException {
        System.out.print("Enter the format : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char format[] = new char[count1];
        for(i=0;i<count1;i++) format[i] = (char) list1.receiveData(i);
        
        boolean flag = false;
        String tempString = "";
        for(i=0;i<count1;i++){
            if(flag){
                if(format[i] == 'd'){
                    System.out.print("Enter an integer : ");
                    int number = SC.nextInt();
                    tempString = intigerFormating(format, count1, number);
                    break;
                }else if(format[i] == 'f'){
                    System.out.print("Enter an float value : ");
                    float number = SC.nextFloat();
                    tempString = floatFormating(format, count1, number);
                    break;
                }else if(format[i] == 's'){
                    System.out.print("Enter an String value : ");
                    String str = SC.nextLine();
                    tempString = tempString + str;
                    break;
                }else if(format[i] == 'x'){
                    System.out.print("Enter an integer : ");
                    int number = SC.nextInt();
                    tempString = hexaDecimalFormating(number);
                    break;
                }else if(format[i] == 'c'){
                    System.out.print("Enter a character : ");
                    char str = (char)BR.read();
                    tempString = tempString + str;
                    break;
                }
            }
            if(format[i] == '%') flag = true;
        }
        System.out.println(tempString);
    }

    private static void getBytes() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        for(i=0;i<count;i++){
            System.out.println(list.receiveData(i));
        }
    }

    private static void getChars() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        System.out.print("Enter the size of an array : ");
        int n = SC.nextInt();
        char charArray[] = new char[n];
        System.out.print("Enter the starting index for the string : ");
        int start = SC.nextInt();
        if(start < 0 || start > count-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.print("Enter the last index for the string : ");
        int last = SC.nextInt() + 1;
        if(last < 0 || last > count-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.print("Enter the starting index for the array : ");
        int startArray = SC.nextInt();
        if(startArray < 0 || startArray > n-1){
            System.out.println("Index out of bound");
            return;
        }
        
        if(n-(startArray+(last-start))<=0){
            System.out.println("Index out of bound");
            return;
        }
        for(i=start;i<last;i++){
            charArray[startArray++] = (char)list.receiveData(i);
        }
        System.out.println(charArray);
    }

    private static void hash_Code() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        int hashCode = 0, temp = 0, power = 1;
        for(i=0;i<count;i++){
            temp = temp + list.receiveData(i);
            for(int j=count;j>i+1;j--){
                power = power*31;
            }
            hashCode = hashCode + (temp*power);
            temp = 0;
            power = 1;
        }
        System.out.println(hashCode);
    }

    private static void indexOf() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        int fromIndex = 0;
        System.out.print("Enter from index : ");
        fromIndex = SC.nextInt();
        if(fromIndex < 0 || fromIndex > count1-1){
            System.out.println("Index out of bound");
            return;
        }
        
        int check = -1;
        for(i=fromIndex;i<count1;i++){
            if(charArray2[0] == charArray1[i]){
                int j;
                for(j=0;j<count2;j++){
                    if(charArray2[j] != charArray1[i+j])
                        break;
                }
                if(j == count2) check = i;
            }
        }
        System.out.println(check);
    }

    private static void intern() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        String tempString = "";
        for(i=0;i<count;i++){
            tempString = tempString + charArr[i];
        }
        System.out.println(tempString);
    }

    private static void isEmpty() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        if(count == 0) System.out.println(false);
        else System.out.println(true);
    }

    private static void lastIndexOf() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        int check = -1;
        for(i=count1-1;i>=0;i--){
            if(charArray2[0] == charArray1[i]){
                int j;
                for(j=0;j<count2;j++){
                    if(charArray2[j] != charArray1[i+j])
                        break;
                }
                if(j == count2){
                    check = i;
                    break;
                }
            }
        }
        System.out.println(check);
    }

    private static void length() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        System.out.println(count);
    }

    private static void match() throws IOException {
        System.out.print("Enter the string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the pattern : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        String pattern = "";
        for(i=0;i<count2;i++) pattern += (char)list2.receiveData(i);
        
        pattern = convertThePatternIntoString(pattern);
        boolean check = true;
        for(i=0;i<count1;i++){
            if(!didContains(charArray1[i],pattern)){
                check = false;
            }
        }
        System.out.println(check);
    }

    private static void offsetByCodePoints() throws IOException {
        System.out.print("Enter the first string : ");
        int i,count1 = 0;
        while((i = BR.read())!='\n'){
            count1 = count1+1;
        }
        
        System.out.println("Enter the Index value");
        int index = SC.nextInt();
        if(index < 0 || index > count1-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.println("Enter the codePointOffset value");
        int codePointOffset = SC.nextInt();
        
        if(codePointOffset + index > count1-1){
            System.out.println("Index out of bound");
            return;
        }
        System.out.println(index + codePointOffset);
    }

    private static void regionMatches() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        int first, last, toffset;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        
        
        System.out.print("Enter the toffset : ");
        toffset = SC.nextInt();
        if(toffset < 0 || toffset > count1-1){
            System.out.println("Index out of bound");
            return;
        }
        char charArray1[] = new char[count1 - toffset];
        int j=0;
        for(i=toffset;i<count1;i++) charArray1[j++] = (char) list1.receiveData(i);
        
        System.out.print("Enter the ooffset : ");
        first = SC.nextInt();
        if(first < 0 || first > count1-1){
            System.out.println("Index out of bound");
            return;
        }
        
        System.out.print("Enter the len : ");
        last = SC.nextInt();
        if(last < 0 || last > count1-1){
            System.out.println("Index out of bound");
            return;
        }
        j=0;
        char charArray2[] = new char[last - first];
        for(i=first;i<last;i++) charArray2[j++] = (char) list2.receiveData(i);
        
        boolean check = false;
        for(i=0;i<count1 - toffset;i++){
            if(charArray2[0] == charArray1[i]){
                for(j=0;j<last - first;j++){
                    if(charArray2[j] != charArray1[i+j])
                        break;
                }
                if(j == count2) check = true;
            }
        }
        System.out.println(check);
    }

    private static void replace() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the character to replace : ");
        char replaceableChar = SC.next().charAt(0);
        System.out.print("Enter the character to be replaced : ");
        char replacingChar = SC.next().charAt(0);
        
        for(i=0;i<count;i++){
            if(charArr[i] == replaceableChar) charArr[i] = replacingChar;
        }
        System.out.println(charArr);
    }

    private static void replaceFirst() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,j = 0,count = 0,count1 = 0,count2 = 0,countSplitCharacter = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        list.clear();
        System.out.print("Enter the string/pattern to replace : ");
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count1++;
        }
        char splitChar[] = new char[count1];
        for(i=0;i<count1;i++){
            splitChar[i] = (char)list.receiveData(i);
        }
        list.clear();
        System.out.print("Enter the replacing string : ");
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count2++;
        }
        String replace = "";
        for(i=0;i<count2;i++){
            replace += (char)list.receiveData(i);
        }
        
        int start=0,end=0;
        i=0;
        String str = "";
        if(splitChar[0] != '[' && splitChar[0] != '\\'){
            while(i<count){
                if(splitChar[0] == charArr[i]){
                    for(j=0;j<count1;j++) if(splitChar[j]!=charArr[j+i]) break;
                    if(j == count1){
                        str += replace;
                        i = (i+j);
                    }
                    break;
                }else{
                    str = str + charArr[i];
                }
                i++;
            }
        }else{
            String pattern = "";
            for(int k=0;k<count1;k++){
                    pattern = pattern + splitChar[k];
            }
            String tempString = convertThePatternIntoString(pattern);
            boolean check = true, insert = false;
            while(i<count){
                check = didContains(charArr[i], tempString);
                if(check){
                    //insert = true;
                    str += replace;
                    i++;
                    break;
                }
                else{
//                    if(insert){
//                        //str += replace;
//                        break;
//                    }else{
//                        str += charArr[i];
//                    }
//                    insert = false;
                    str += charArr[i];
                    i++;
                }
            }
        }
        for(int k = i;k<count;k++) str += charArr[k];
        System.out.println(str);
    }

    private static void replaceAll() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,j = 0,count = 0,count1 = 0,count2 = 0,countSplitCharacter = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        list.clear();
        System.out.print("Enter the string/pattern to replace : ");
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count1++;
        }
        char splitChar[] = new char[count1];
        for(i=0;i<count1;i++){
            splitChar[i] = (char)list.receiveData(i);
        }
        list.clear();
        System.out.print("Enter the replacing string : ");
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count2++;
        }
        String replace = "";
        for(i=0;i<count2;i++){
            replace += (char)list.receiveData(i);
        }
        
        int start=0,end=0;
        i=0;
        String str = "";
        if(splitChar[0] != '[' && splitChar[0] != '\\'){
            while(i<count){
                if(splitChar[0] == charArr[i]){
                    for(j=0;j<count1;j++) if(splitChar[j]!=charArr[j+i]) break;
                    if(j == count1){
                        str += replace;
                        i = (i+j) - 1;
                    }
                }else{
                    str = str + charArr[i];
                }
                i++;
            }
        }else{
            String pattern = "";
            for(int k=0;k<count1;k++){
                    pattern = pattern + splitChar[k];
            }
            String tempString = convertThePatternIntoString(pattern);
            boolean check = true, insert = false;
            while(i<count){
                check = didContains(charArr[i], tempString);
                if(check){
                    str += replace;
                    i++;
                }
                else{
                    str += charArr[i];
                    i++;
                }
            }
        }
        System.out.println(str);
    }

    private static void split() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,j = 0,count = 0,count1 = 0,countSplitCharacter = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        list.clear();
        System.out.print("Enter the string which splits the string : ");
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count1++;
        }
        char splitChar[] = new char[count1];
        for(i=0;i<count1;i++){
            splitChar[i] = (char)list.receiveData(i);
        }
        
        int start=0,end=0;
        i=0;
        String str = "";
        ArrayList<String> strList = new ArrayList<>();
        if(splitChar[0] != '[' && splitChar[0] != '\\'){
            while(i<count){
                if(splitChar[0] == charArr[i]){
                    for(j=0;j<count1;j++) if(splitChar[j]!=charArr[j+i]) break;
                    if(j == count1){
                        end = i;
                        for(int k=start;k<end;k++){
                            str = str + charArr[k];
                        }
                        strList.add(str);
                        str = "";
                        start = i+j;
                        i = (i+j) - 1;
                    }
                }
                i++;
            }
            if(j == count1){
                end = i;
                for(int k=start;k<end;k++){
                    str = str + charArr[k];
                }
                strList.add(str);
                str = "";
                start = i+j;
                i = (i+j) - 1;
            } 
        }else{
            String pattern = "";
            for(int k=0;k<count1;k++){
                    pattern = pattern + splitChar[k];
            }
            String tempString = convertThePatternIntoString(pattern);
            str = "";
            boolean check = true;
            for(i=0;i<count;i++){
                check = didContains(charArr[i], tempString);
                if(check == false){
                    str += charArr[i];
                }
                else{
                    strList.add(str);
                    str = "";
                }
            }strList.add(str);
        }
        for(String str1 : strList){
            if(str1 != "")System.out.println(str1);
        }
    }

    private static void startsWith() throws IOException {
        System.out.print("Enter the first string : ");
        LinkList list1 = new LinkList();
        int i,count1 = 0, count2 = 0;
        while((i = BR.read())!='\n'){
            list1.insertData(i);
            count1 = count1+1;
        }
        char charArray1[] = new char[count1];
        for(i=0;i<count1;i++) charArray1[i] = (char) list1.receiveData(i);
        
        LinkList list2 = new LinkList();
        System.out.print("Enter the second string : ");
        while((i = BR.read())!='\n'){
            list2.insertData(i);
            count2 = count2+1;
        }
        char charArray2[] = new char[count2];
        for(i=0;i<count2;i++) charArray2[i] = (char) list2.receiveData(i);
        
        boolean check = true;
        if(count1 > count2){
            int j = 0;
            for(i=0;i<count1-count2;i++){
                if(charArray1[i] != charArray2[j++]) check = false;
            }
        }else check = false;
        System.out.println(check);
    }

    private static void subSequence() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the first index : ");
        int first;
        first = SC.nextInt();
        if(first < 0){
            System.out.println("Index out of bound");
            return;
        }
        System.out.print("Enter the last index : ");
        int last;
        last = SC.nextInt();
        if(last > count-1){
            System.out.println("Index out of bound");
            return;
        }
        String tempString = "";
        for(i=first;i<last;i++) tempString += charArr[i];
        CharSequence charSeq = tempString;
        System.out.println(charSeq);
    }

    private static void subString() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.print("Enter the first index : ");
        int first;
        first = SC.nextInt();
        if(first < 0){
            System.out.println("Index out of bound");
            return;
        }
        System.out.print("Enter the last index : ");
        int last;
        last = SC.nextInt();
        if(last > count-1){
            System.out.println("Index out of bound");
            return;
        }
        
        String tempString = "";
        for(i=first;i<last;i++) tempString = tempString + charArr[i];
        System.out.println(tempString);
    }

    private static void toCharArray() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        System.out.println(charArr);
    }

    private static void toLowerCase() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the first string : ");
        int i,count1 = 0;
        while((i = BR.read())!='\n'){
            if(i>=65 && i<=90) i = i+32;
            list.insertData(i);
            count1 = count1+1;
        }
        String tempString = "";
        for(i=0;i<count1;i++){
            tempString += (char)list.receiveData(i);
        }
        System.out.println(tempString);
    }

//    private static void to_String() {
//        int intValue;
//        float doubleValue;
//        char charValue;
//        String intString = "", doubleString = "", charString = "";
//        System.out.print("Enter any integer value : ");
//        intValue = SC.nextInt();
//        System.out.print("Enter any float value : ");
//        doubleValue = SC.nextFloat();
//        System.out.print("Enter any character value : ");
//        charValue = SC.next().charAt(0);
//        
//        int tempInt = intValue;
//        LinkList list = new LinkList();
//        int count = 0;
//        while(tempInt>0){
//            int n = tempInt%10;
//            list.insertData(n);
//            tempInt = tempInt/10;
//            count++;
//        }
//        for(int i=count-1;i>=0;i--) intString += list.receiveData(i);
//        list.clear();
//        count = 0;
//        
//        float tempFloat = doubleValue*1000000;
//        int extraZeros = 0;
//        tempInt = (int)tempFloat;
//        while(tempInt>0){
//            if(count == 6){
//                list.insertData((int)'.');
//                count++;
//                continue;
//            }
//            int n = tempInt%10;
//            list.insertData(n);
//            tempInt = tempInt/10;
//            count++;
//        }
//        for(int i=0;i<count;i++){
//            if(list.receiveData(i) == 0) extraZeros++;
//            else break;
//        }
//        for(int i=count-1;i>=0+extraZeros;i--){
//            if(list.receiveData(i)>=0 && list.receiveData(i)<=9){
//                doubleString += list.receiveData(i);
//            }else doubleString += (char)list.receiveData(i);
//        }
//        list.clear();d
//        count = 0;
//        
//        charString = "";
//        charString = charString + charValue;
//        
//        System.out.println(intString);
//        System.out.println(doubleString);
//        System.out.println(charString);
//    }
    private static void to_String(){
        Generic obj = new Generic();
        System.out.print("Enter 1-Integer, 2-Float, 3-Character, 4-Null : ");
        int n = SC.nextInt();
        String str = "";
        System.out.print("Enter value : ");
        switch(n){
            case 1 -> obj.anyValue = SC.nextInt();
            case 2 -> obj.anyValue = SC.nextFloat();
            case 3 -> obj.anyValue = SC.next().charAt(0);
            case 4 -> obj.anyValue = null;    
        }
        if(obj.anyValue == null){
            System.out.println("Null Pointer Exception");
            return;
        }else str = str+obj.anyValue;
        System.out.print("The string is : ");
        System.out.println(str);
    }

    private static void toUpperCase() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the first string : ");
        int i,count1 = 0;
        while((i = BR.read())!='\n'){
            if(i>=97 && i<=122) i = i-32;
            list.insertData(i);
            count1 = count1+1;
        }
        String tempString = "";
        for(i=0;i<count1;i++){
            tempString += (char)list.receiveData(i);
        }
        System.out.println(tempString);
    }

    private static void trim() throws IOException {
        LinkList list = new LinkList();
        System.out.print("Enter the string : ");
        int i,count = 0;
        while((i = BR.read())!='\n'){
            list.insertData(i);
            count++;
        }
        char charArr[] = new char[count];
        for(i=0;i<count;i++){
            charArr[i] = (char)list.receiveData(i);
        }
        int lastSpaceCount = 0, initialSpace = 0;
        String tempString = "";
        for(i=0;i<count;i++) if(charArr[i] == ' ') initialSpace++;
        for(i=count-1;i>=0;i--) if(charArr[i] == ' ') lastSpaceCount++;
        for(i=initialSpace;i<count-lastSpaceCount;i++) tempString += charArr[i];
        System.out.println(tempString);
    }

    private static void valueOf() {
        Generic obj = new Generic();
        System.out.print("Enter 1-Integer, 2-Float, 3-Character, 4-Null : ");
        int n = SC.nextInt();
        String str = "";
        System.out.println("Enter value : ");
        switch(n){
            case 1 -> obj.anyValue = SC.nextInt();
            case 2 -> obj.anyValue = SC.nextFloat();
            case 3 -> obj.anyValue = SC.next().charAt(0);
            case 4 -> obj.anyValue = "null";    
        }
        str = str+obj.anyValue;
        System.out.println(str);
    }

    private static String intigerFormating(char[] format, int count1, int number) {
        String result = "";
        int i=0;
        for(i=0;i<count1;i++){
            if(format[i] == '%') break;
            result += format[i];
        }
        char temp = ' ';
        int tempNum = 0, count = 0;
        if(format[++i] == '0') temp = '0';
        else i--;
        while(format[++i] != 'd') tempNum = tempNum*10 + (format[i]-'0');
        int after = i+1;
        int tempInt = number;
        while(tempInt > 0){
            tempInt = tempInt/10;
            count++;
        }
        for(i=0;i<tempNum-count;i++) result = result + temp;
        result = result + number;
        for(i=after;i<count1;i++) result = result + format[i];
        return result;
    }

    private static String floatFormating(char[] format, int count1, float number) {
        LinkList list6 = new LinkList();
        String result = "";
        int i=0, j=0;
       
        for(i=0;i<count1;i++){
            if(format[i] == '%') break;
            result += format[i];
        }
        
        for(j=i;j<count1;j++){
            if(format[j] == '.') break;
        }
        int precision = 0;
        while(format[++j] != 'f') precision = precision*10 + (format[j]-'0');

        for(j=0;j<precision+1;j++) number = number*10;
        int tempNum = (int)number;

        int tempInt = tempNum;
        int count = 0;
        boolean flag = false;
        int n=0;
        while(tempInt>0){
            if(count == precision+1){
                list6.insertData((int)'.');
                count++;
                continue;
            }
            if(count == 0){
                n = tempInt%10;
                if(n >= 5) flag = true;
                tempInt = tempInt/10;
                count++;
            }else if(flag){
                n = tempInt%10;
                list6.insertData(n+1);
                tempInt = tempInt/10;
                count++;
                flag = false;
            }else{
                n = tempInt%10;
                list6.insertData(n);
                tempInt = tempInt/10;
                count++;
            }
        }
        count = count -1;
        char temp = ' ';
        int tempNumber = 0, count2 = 0;
        if(format[++i] == '0') temp = '0';
        else i--;
        while(format[++i] != '.') tempNumber = tempNumber*10 + (format[i]-'0');
        float tempInteger = number;
        while(tempInt >= 1){
            tempInteger = tempInteger/10;
            count2++;
        }
        for(j=0;j<tempNumber-count2;j++) result = result + temp;
        while(format[++i] != 'f');
        int after = i+1;

        for(i=count-1;i>=0;i--){
            if(list6.receiveData(i)>=0 && list6.receiveData(i)<=9){
                result += list6.receiveData(i);
            }else result += (char)list6.receiveData(i);
        }
        for(i=after;i<count1;i++) result = result + format[i];
        
        return result;
    }

    private static String hexaDecimalFormating(int number) {
        int quotient, remainder;
        int i, j = 0;
        String str = "";

        quotient = number;

        while (quotient != 0)
        {
            remainder = quotient % 16;
            if (remainder < 10)
                str += (char)(48 + remainder);
            else
                str += (char)(48 + remainder);
            quotient = quotient / 16;
        }
        return str;
    }
    
    private static String convertThePatternIntoString(String pattern){
        String tempString = "";
        int start = -1, end = -1;
        if(pattern.charAt(0) == '['){
            int i=1;
            while(i<pattern.length()){
                if(pattern.charAt(i) == '-'){
                    i++;
                    continue;
                    
                }
                else if(start != -1 && end != -1){
                    for(int j=start;j<=end;j++){
                        tempString = tempString + (char)j;
                    }
                    start = -1;
                    end = -1;
                }else if(start == -1){
                    start = (int)pattern.charAt(i);
                    i++;
                }
                else if(end == -1){
                    end = (int)pattern.charAt(i);
                    i++;
                }else if(pattern.charAt(i) == ']'){
                    break;
                }
            }
        }else if(pattern.charAt(0) == '\\'){
            if(pattern.charAt(1) == 'd'){
                for(int i='0';i<='9';i++) tempString = tempString + (char)i;
            }else if(pattern.charAt(1) == 'w'){
                for(int i='a';i<='z';i++) tempString = tempString + (char)i;
                for(int i='A';i<='Z';i++) tempString = tempString + (char)i;
                for(int i='0';i<='9';i++) tempString = tempString + (char)i;
                tempString = tempString + '_';
            }else if(pattern.charAt(1) == 's'){
                tempString = tempString + ' ';
            }
        }
        
        return tempString;
    }
    
    private static boolean didContains(char c,String pattern) {
        char[] charArray1 = pattern.toCharArray();
        boolean check = false;
        int count1 = pattern.length();
        for(int i=0;i<count1;i++){
            if(c == charArray1[i]){
                check = true;
            }
        }
        return check;
    }
}
