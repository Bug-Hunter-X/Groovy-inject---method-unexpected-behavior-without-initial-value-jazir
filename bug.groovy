def list = [1, 2, 3, 4, 5]

println list.sum() //Expected output: 15
println list.inject(0) { sum, element -> sum + element } //Expected output: 15
println list.inject { sum, element -> sum + element } // Unexpected output: 15

//The third statement using inject without initial value gives the correct result although it is not very readable and might be problematic with different data types.