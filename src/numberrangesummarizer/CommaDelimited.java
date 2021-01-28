/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberrangesummarizer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.lang.model.element.Element;

/**
 *
 * @author Franco
 */
public class CommaDelimited implements NumberRangeSummarizer {

    public static void main(String[] args) {

        String inputValues = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String displayNew = "";
        //createing new instance of commaDelimeted to access the Interface "NumberRangeSummarizerInterface" methods
        NumberRangeSummarizer creation = new CommaDelimited();

        //Using Collection to pass towards the summarizeCollection
        displayNew = creation.summarizeCollection(creation.collect(inputValues));

        //display the produced comma delimited list of numbers
        System.out.println(displayNew);

    }

    @Override
    public Collection<Integer> collect(String input) {

        //Integer variable to use in bubblesort
        Integer temp;
        boolean sorted = false;
        //Putting the values first in a array so each has its own index values and not be part of only one index within a list
        String[] sA = input.split(",");
        //Creating an Integer List of same length as string array
        List<Integer> iL = new ArrayList<Integer>();

        //placing values string array in integer List
        for (int i = 0; i < sA.length; i++) {
            iL.add(Integer.parseInt(sA[i]));
        }

        //Bubble sorting the List
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < iL.size() - 1; i++) {
                if (iL.get(i).compareTo(iL.get(i + 1)) > 0) {
                    temp = iL.get(i);
                    iL.set(i, iL.get(i + 1));
                    iL.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        //returning list to summarizeCollection
        return iL;

    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        Integer temp, temp2, first, tempC, temp2C, second;
        //Creating a stringBuffer to add strings
        StringBuffer add = new StringBuffer();

        //Creating new ArrayList
        List<Integer> iL = new ArrayList<Integer>();
        //placing Collection into an ArrayList
        iL.addAll(input);

        //unit test
        //increment to the next range that increments
        for (int i = 0; i < iL.size(); i++) {
            //getting last element and testing wheter the element in front of the last element is the same else it should place a comma in between
            if (i == iL.size() - 1) {
                if (iL.get(iL.size() - 2) != iL.get(iL.size() - 1)) {
                    add.append(iL.get(i) + ",");
                }
                break;
            }

            first = iL.get(i);
            second = iL.get(i + 1);
            //if the second value is 1 greater than the first value then it means there is an increment of 1
            //meaning there must be a range till the last number of the range is found, else go to the value that is next with the difference bigger than 1

            if (second == first + 1) {
                tempC = first;

                //loop until the end of the rangegroup is found
                for (int j = i + 1;; j++) {
                    first = iL.get(j);
                    second = iL.get(j + 1);

                    //if there is still a element that differentiate by 1 incrementing value continue till no increment in the range anymore                    
                    if (second != first + 1) {
                        //stating i=j again to start incrementing from the location it left off and appending the values before breaking out the loop
                        i = j;
                        add.append(tempC + "-" + (Integer) iL.get(i) + ", ");
                        break;
                    }
                }
            } else {
                // goes through the the ones with no raNGE
                add.append(iL.get(i) + ", ");
            }
        }
        //removing the excess comma that is placed after the existing value
        String toReturn = add.toString();
        return toReturn.substring(0, toReturn.length() - 1);
    }

}
