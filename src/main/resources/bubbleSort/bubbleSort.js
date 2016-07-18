function bubbleSort(items) {
  var length = items.length;
  for (var i = 0; i < length; i++) {
    for (var j = 0; j < (length - i - 1); j++) {
      if(items[j] > items[j+1]) {
        var tmp = items[j];
        items[j] = items[j+1];
        items[j+1] = tmp;
      }
    }        
  }
}

function createArray(numberOfItems) {
	var items = [];
	for (var i = 0; i < numberOfItems; i++) {
		items[i] = Math.floor((Math.random() * 100000));
	}
	return items;
}



for (var i = 0; i < 1000; i++) {
	var items = createArray(1000);
	bubbleSort(items);
}
