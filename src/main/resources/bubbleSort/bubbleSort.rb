def bubble_sort(list)
  return list if list.size <= 1 # already sorted
  swapped = true
  while swapped do
    swapped = false
    0.upto(list.size-2) do |i|
      if list[i] > list[i+1]
        list[i], list[i+1] = list[i+1], list[i] # swap values
        swapped = true
      end
    end    
  end

  list
end

def create_array(numberOfElements)
  array = Array.new(numberOfElements)
  0.upto(numberOfElements) do |i|
    array[i] = rand(100000)
  end
  return array
end

0.upto(1000) do 
  array = create_array(1000)
  bubble_sort(array)
end
