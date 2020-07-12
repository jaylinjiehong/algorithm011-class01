## 第三周学习笔记
### 泛型递归
+ Python代码模板
```
def recursion(level,param1,param2,...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        return

    #process logic in current level
    process(level,data...)

    # drill down
    self.recursion(level+1,p1,...)

    # reverse the current level status if needed
```
+ java 代码模板
```
public void recur(int level,int param){
    // terminator
    if(level>MAX_LEVEL){
        //process result
        return;
    }

    //process current logic
    process(level,param);

    //drill down
    recur(level:level+1,newParam);

    //restore current status
}
```
+ 思维要点
+ 1、不要人肉进行递归（最大误区）
+ 2、找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
+ 3、数学归纳法思维
### 分治 Divide&Conquer
+ 分治代码模板
```
def divide_conquer(problem,param1,param2,...):
    # recursion terminator
    if problem is None:
        print_result
        return

    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem,data)

    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0],p1,...)
    subresult2 = self.divide_conquer(subproblems[1],p1,...)
    subresult3 = self.divide_conquer(subproblems[2],p1,...)
    ...

    # process and generate the final result
    result = process_result(subresult1,subresult2,subresult3,...)

    # revert the current level status
```
### 回溯 Backtracking
+ 回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。