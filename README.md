<b>Abstract<b><p>
	The aim of this code is developed a program to add 50.000 records to B Tree. I generated randomly 50.000 unique numbers for identity key (TC number). I saved identity numbers with name-surname and address information. This information was generated randomly.
Completion Report
The assignment was completed. Add person information to B Tree. While adding to B tree, disk-write and disk-read operation was realized on BTree file. Records was sorted depends on the identity key number. At the end of program all records was in order in BTree file.
Functional Decomposition
 createBTree : The function creates B-Tree.
 displayBTree: The function shows n elements.  searchPeople: The function finds one element.
 upDatePeople: The function update one person information.
 insertionPeople : The function adds new element in b-tree.
 writeDisk: The function provides recording all elements in the file.
 readDisk: The function provides reading last information.
 hastableInsertion: The function provides two times same element can’t add in b-tree.
 My assingment has got two file for recording information. First file is node.txt this provides finding node’s people. Second file is people.txt this provides recording all people information.
HIGH LEVEL ORGANIZATION
main class
createBtree searchPeople updatePeople displayPeople insertionPeople
insertionPeople writeDisk readDisk
Clickstreams
The aim of the assigment is record is sorted depends on the identity key number. At the end of program all records is be in order in BTree file. The all records is saved in one file. So any information doesn’t lose in no time.
