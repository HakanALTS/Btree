.# BTREE-java 
<p>
<b><center>Abstract</center></b><p>
The aim of this code is developed a program to add 50.000 records to B Tree. I generated randomly 50.000 unique numbers for identity key. I saved identity numbers with name-surname and address information. This information was generated randomly.
<p>
<b><center>Completion</center></b><p>
Add person information to B Tree. While adding to B tree, disk-write and disk-read operation was realized on BTree file. Records was sorted depends on the identity key number. At the end of program all records was in order in BTree file.
<p>
<b><center>Functional Decomposition</center></b><p>

<p><b>createBTree:</b> The function creates B-Tree.
<p><b>displayBTree:</b> The function shows n elements.
<p><b>searchPeople:</b> The function finds one element.
<p><b>upDatePeople:</b> The function update one person information.
<p><b>writeDisk:</b> The function provides recording all elements in the file.
<p><b>readDisk:</b> The function provides reading last information.
<p><b>hastableInsertion:</b> The function provides two times same element can’t add in b-tree.
<p><p>
Code has got two file for recording information. First file is node.txt this provides finding node’s people. Second file is people.txt this provides recording all people information.











