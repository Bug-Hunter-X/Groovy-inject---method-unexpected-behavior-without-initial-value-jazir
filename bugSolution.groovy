The Groovy `inject()` method should ideally throw a more informative exception when the initial value is omitted and the list contains non-numeric elements, or it should clearly state the behavior (e.g. using the first element as the initial value in such cases).  The provided solution enhances this by introducing an explicit check for numeric data types and throwing a custom exception for non-numeric lists when no initial value is provided.

def list = [1, 2, 3, 4, 5]

def list2 = ['a', 'b', 'c']

println list.sum()
println list.inject(0) { sum, element -> sum + element }

try{
println list.inject { sum, element -> sum + element }
}catch(Exception e){
println "Exception caught: ${e.message}"
}

try{
println list2.inject { sum, element -> sum + element }
}catch(Exception e){
println "Exception caught: ${e.message}"
}


//Enhanced version of inject
class MyList extends ArrayList{
    def enhancedInject(Closure closure) {
        if(this.isEmpty()){
            return null
        } 
        if(this.every { it instanceof Number }){
            return inject(this[0]) { sum, element -> closure.call(sum, element) }
        } else {
            throw new IllegalArgumentException("Cannot use inject() without initial value on a list that contains non-numeric elements.")
        }
    }
}

def myList = new MyList([1, 2, 3, 4, 5])
def myList2 = new MyList(['a','b','c'])
println myList.enhancedInject {sum, element -> sum + element}

try{
    println myList2.enhancedInject {sum, element -> sum + element}
} catch(IllegalArgumentException e){
    println "Exception caught: ${e.message}"
}
