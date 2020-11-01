1.method:
set two points starting from  j=0 i=list.size()-1 ,
then  j++ i-- ,
and then  comare sum(list[i]+list[j]) with budget

2.
>mvn clean
>build  mvn test(see case in Apptest)

3.Answers to questions:
   A). What is the performance of the algorithm you implemented? Describe your answer using Big-O
   notation.
    Ans: we just just one layer forloop 2 times ,so it is O(2n);

   B). How would you modify your solution to select three items? Additionally, how would you extend
   your solution to handle n items?
   Ans : if 3 items, we can find the closed number to the budget(say budget is 200,then 145.95 is the closed number in previous example ),
   then we can simplify the problem to two-item problem which the two items' sum is close to 200-146.maybe this is not the final answer.
   Then we can choose another closed number 129.95,and try again ,so on so forth.
   
    If n items,we can first divide the list into n equal groups based on the interval [0-budget/n],[budget/n 2*budget/n]...,


   C). Assume your algorithm must be able to process a list with billions of records. What additional
   considerations would affect your solution's design?
   Ans:we can use stream to deal with the data or use distruted file system.
