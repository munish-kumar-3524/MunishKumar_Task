/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algebricequation;
import java.util.*;

/**
 *
 * @author Munish kumar
 */
public class AlgebricEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String result;
        List<String> sum = null;
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        char check = getTheOperation(inputString);
        if(check == '(' || check == '*')
            sum = execuit(inputString);
        else if(check == '+')
            sum = convertTheInputStringIntoSimplifingListForAdditionOperation(inputString);
        else if(check == '-')
            sum = convertTheInputStringIntoSimplifingListForSubtractionOperation(inputString);
       //System.out.println(sum);
        sum = simplify(sum);
        //System.out.println(sum);
        result = getFinalResult(sum);
        //System.out.println(sum);
        System.out.println(result);
    }

    private static List<String> execuit(String inputString) {
        List<String> result = new ArrayList<>();
        List<List<String> > listOfExpressions = new ArrayList<>();
        listOfExpressions = breakTheExpression(inputString);
        //starts here
        result = comput(listOfExpressions);
        return result;
    }

    private static List<List<String>> breakTheExpression(String inputString) {//with in the brackets
        List<List<String> > listOfExpressions = new ArrayList<>();
        List<String> fullExpression = new ArrayList<>();
        int start = 0, end = 0;
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) == '('){
                start = i+1;
                for(int j=start;j<inputString.length();j++){
                    if(inputString.charAt(j) == ')'){
                        end = j;
                        break;
                    }
                }
                fullExpression.add(inputString.substring(start, end));
            }
        }
        List<String> breakedExpression = new ArrayList<>();
        for(int i=0;i<fullExpression.size();i++){
            breakedExpression = getBreakedExpression(fullExpression.get(i));
            listOfExpressions.add(breakedExpression);
        }
        //System.out.println(listOfExpressions);
        return  listOfExpressions;
    }

    private static List<String> getBreakedExpression(String fullExpression) {//further dividing the expression based on operators
        List<String> breakedExpression = new ArrayList<>();
        int start = 0;
        for(int i=0;i<fullExpression.length();i++){
            if(fullExpression.charAt(i) == '+' || fullExpression.charAt(i) == '-'){
                breakedExpression.add(fullExpression.substring(start, i));
                start = i;
            }else if(i == fullExpression.length()-1){
                breakedExpression.add(fullExpression.substring(start, i+1));
            }
        }
        //System.out.println(breakedExpression);
        return breakedExpression;
    }

    private static List<String> comput(List<List<String>> listOfExpressions) {
        List<String> tempList = combineTwoExpressions(listOfExpressions.get(0), listOfExpressions.get(1));
        for(int i=2;i<listOfExpressions.size();i++){
            tempList = combineTwoExpressions(tempList, listOfExpressions.get(i));
        }
        return tempList;
    }

    private static List<String> combineTwoExpressions(List<String> tempList1, List<String> tempList2) {
        List<String> tList = new ArrayList<>();
        //System.out.println(tempList1);
        for(int i=0;i<tempList1.size();i++){
            Node n1 = convertToNode(tempList1.get(i));
            for(int j=0;j<tempList2.size();j++){
                Node n2 = convertToNode(tempList2.get(j));
                Node n3 = combine(n1, n2);
                tList.add(convertToString(n3));
            }
        }
        return tList;
    }
    
    private static Node convertToNode(String tempStr) {
        Node n1 = new Node();
        String tempString = tempStr;
        
        //System.out.println(tempString);
        
        if(tempString.charAt(0) == '+'){
            n1.operator = '+';
            tempString = tempString.substring(1, tempString.length());
        }else if(tempString.charAt(0) == '-'){
            n1.operator = '-';
            tempString = tempString.substring(1, tempString.length());
        }else n1.operator = '+';
        
        //System.out.println(tempString);
        //System.out.println(tempString + "-->" +tempString.length());
        
        int number = 0;
        if(tempString.charAt(0)>='0' && tempString.charAt(0)<='9'){
            while(tempString.charAt(0)>='0' && tempString.charAt(0)<='9'){
                number = number*10 + Integer.parseInt(String.valueOf(tempString.charAt(0)));
                if(tempString.length() == 1) break;
                else tempString = tempString.substring(1, tempString.length());
            }
            n1.value = number;
        }else n1.value = 1;
        
        //System.out.println(n1.value);
        //System.out.println(tempString + "-->" +tempString.length());
        
        if(tempString.charAt(0)>='0' && tempString.charAt(0)<='9'){
            //System.out.println("asdfdf");
            return n1;
        }

        number = 1;
        String key = String.valueOf(tempString.charAt(0));
        for(int i=1;i<tempString.length();i++){
            if(tempString.charAt(i)=='^') continue;
            if(tempString.charAt(i)>='0' && tempString.charAt(i)<='9'){
                number = Integer.parseInt(String.valueOf(tempString.charAt(i)));
            }else{
                n1.setMap(key, number);
                key = String.valueOf(tempString.charAt(i));
                number = 1;
            }
        }
        n1.setMap(key, number);
        
//        System.out.println();
//        System.out.println(n1.operator);
//        System.out.println(n1.value);
//        System.out.println(n1.map);
//        System.out.println();
        
        return n1;
    }

    private static Node combine(Node n1, Node n2) {
        
        Node tempNode = new Node();
        tempNode.value = n1.value*n2.value;
        
        if(n1.operator == n2.operator) tempNode.operator = '+';
        else tempNode.operator = '-';
        
        tempNode.map = (TreeMap<String, Integer>) n1.map.clone();
        Set<String> set =  n2.map.keySet();
        Object[] arr = set.toArray();
        for (Object arr1 : arr) {
            if (tempNode.map.containsKey(arr1)) {
                tempNode.map.put((String) arr1, n2.map.get(arr1) + tempNode.map.get(arr1));
            }else{
                tempNode.map.put((String) arr1, n2.map.get(arr1));
            }
        }

        return tempNode;
    }

    private static String convertToString(Node n3) {
        String str = "";
        str = str+n3.operator;
        str = str+n3.value;
        Set<String> set =  n3.map.keySet();
        Object[] arr = set.toArray();
        
        for(Object arr1:arr){
            str = str+(String)arr1;
            if(n3.map.get(arr1)!=1) str = str+n3.map.get(arr1);
        }
        return str;
    }

    private static List<String> simplify(List<String> sum) {
        List<String> order = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<sum.size();i++){
            String tempString = sum.get(i);
            int j = 0;
            while(j<tempString.length()){
                if(tempString.charAt(j) == '-' || tempString.charAt(j) == '+' || (tempString.charAt(j)>='0' && tempString.charAt(j)<='9')){
                   j++;
                }else break;
            }

            int number = 0;
            String key = tempString.substring(j, tempString.length());
            //System.out.println(key);
            if(tempString.substring(0, j).equals("+")) number = 1;
            else if(tempString.substring(0, j).equals("-")) number = -1;
            else number = Integer.parseInt(tempString.substring(0, j));
            
            if(map.containsKey(key)){
                map.put(key, map.get(key)+ number);
            }else{
                map.put(key, number);
                order.add(key);
            }
        }
        String tempString = "";
        List<String> tempList = new ArrayList<>();
        for(int i=0;i<order.size();i++){
            if(map.get(order.get(i)) == 0) continue;
            else if(map.get(order.get(i)) == 1){
                if(order.get(i).equals("")) tempString = "1";
                else tempString = order.get(i);
                tempList.add(tempString);
            }
            else{
                tempString = map.get(order.get(i))+order.get(i);
                tempList.add(tempString);
            }
        }
        return tempList;
    }

    private static String getFinalResult(List<String> sum) {
        
        String finalResult = "";
        if(sum.isEmpty()) return finalResult;
        finalResult = finalResult + sum.get(0);
        for(int i=1;i<sum.size();i++){
            String tempString = sum.get(i);
            if(tempString.charAt(0) == '-'){
                finalResult = finalResult + sum.get(i);
            }else{
                finalResult = finalResult + '+' + sum.get(i);
            }
        }
        return finalResult;
    }
    
    private static char getTheOperation(String inputString) {
        
        boolean temp = false;
        char c = ' ';
        for(int i=0;i<inputString.length();i++){
            if(temp){
                //if(inputString.charAt(i)== '*') return true;
                c = inputString.charAt(i);
                break;
            }
            
            if(inputString.charAt(i) == ')') temp = true;
        }
        return c;
    }
    
    private static List<String> convertTheInputStringIntoSimplifingListForAdditionOperation(String inputString) {
        List<String> tempList = new ArrayList<>();
        String tempString = "";
        if(inputString.charAt(1) == '-'){
            tempString = tempString + '-';
            inputString = inputString.substring(2, inputString.length());
        }
        else tempString = tempString + '+';
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) == ')' || inputString.charAt(i) == '(' || inputString.charAt(i) == '^') continue;
            else if(inputString.charAt(i) == '+' || inputString.charAt(i) == '-'){
                tempList.add(tempString);
                tempString = "";
                tempString = tempString + inputString.charAt(i);
            }else{
                tempString = tempString + inputString.charAt(i);
            }
        }
        tempList.add(tempString);
        return tempList;
    }
    
    private static List<String> convertTheInputStringIntoSimplifingListForSubtractionOperation(String inputString) {
        List<String> tempList = new ArrayList<>();
        String tempString = "";
        if(inputString.charAt(1) == '-'){
            tempString = tempString + '-';
            inputString = inputString.substring(2, inputString.length());
        }
        else tempString = tempString + '+';
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) == '^' || inputString.charAt(i) == '(') continue;
            if(inputString.charAt(i) == ')'){
                inputString = inputString.substring(i+2, inputString.length());
                break;
            }
            else if(inputString.charAt(i) == '+' || inputString.charAt(i) == '-'){
                tempList.add(tempString);
                tempString = "";
                tempString = tempString + inputString.charAt(i);
            }else{
                tempString = tempString + inputString.charAt(i);
            }
        }
        tempList.add(tempString);
        
        tempString = "-";
        
        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i) == '^'|| inputString.charAt(i) == '('|| inputString.charAt(i) == ')') continue;
            if(inputString.charAt(i) == '+'){
                tempList.add(tempString);
                tempString = "";
                tempString = tempString + '-';
            }else if(inputString.charAt(i) == '-'){
                tempList.add(tempString);
                tempString = "";
                tempString = tempString + '+';
            }else{
                tempString = tempString + inputString.charAt(i);
            }
        }
        tempList.add(tempString);
        
        return tempList;
    }
}
