Zezhi Wang

Exerxise 1:
Lexicon: small-lex.txt  Document: emma.txt  Class: DoublyLinkedList
==========================================
 words      elapsed    pct of
searched   time (ms) found words
    5000         548      91.0%
   10000        1099      91.3%
   15000        1674      90.8%
   20000        2219      90.7%
   25000        2789      90.7%
Lexicon: small-lex.txt  Document: emma.txt  Class: MRUList
==========================================
 words      elapsed    pct of
searched   time (ms) found words
    5000         216      91.0%
   10000         360      91.3%
   15000         528      90.8%
   20000         696      90.7%
   25000         828      90.7%

The result of MRUList is much faster than DoublyLinkedList.
I can harly find the worst case running time to be the same, since the elapsed time is so much different.


Exercise 2:
Sometimes it holds for my observation and sometimes it doesn't. MRUList seems to be more stable and lessly affected while DoublyLinkedList seems to have more abnormal values.


Exercise 3:
Lexicon: medium-lex.txt  Document: emma.txt  Class: DoublyLinkedList
==========================================
 words      elapsed    pct of
searched   time (ms) found words
    5000        1525      95.9%
   10000        8109      96.3%
   15000       11619      96.5%
   20000       13965      96.6%
   25000       16619      96.6%
Lexicon: medium-lex.txt  Document: emma.txt  Class: MRUList
==========================================
 words      elapsed    pct of
searched   time (ms) found words
    5000         899      95.9%
   10000        1065      96.3%
   15000        2231      96.5%
   20000        2647      96.6%
   25000        2965      96.6%

Lexicon: large-lex.txt  Document: emma.txt  Class: DoublyLinkedList
==========================================
 words      elapsed    pct of
searched   time (ms) found words
    5000        7489      95.9%
   10000       15092      96.5%
   15000        5968      96.5%
   20000       30442      96.6%
   25000       37872      96.6%
Lexicon: large-lex.txt  Document: emma.txt  Class: MRUList
==========================================
 words      elapsed    pct of
searched   time (ms) found words
    5000        2196      95.9%
   10000        2938      96.5%
   15000        4698      96.5%
   20000        5696      96.6%
   25000        4050      96.6%

The elapsed times seems to have linear relations with how large the lexicon file is. And the MRUList seems to be affected less than DoublyLinkedList. Because the ratio between elapsed times of MRUList is smaller than that of DoublyLinkedList. 