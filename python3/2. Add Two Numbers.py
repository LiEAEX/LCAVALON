# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        node = root = ListNode(-1)
        #node = node.next
        c = 0
        
        while l1 or l2:
            if l1 and l2:
                node.next = ListNode((l1.val + l2.val + c) % 10)
                if l1.val + l2.val + c >= 10: 
                    c = 1
                else: 
                    c = 0                        
                l1 = l1.next
                l2 = l2.next
                node = node.next
            
            elif l1 and not l2:
                node.next = ListNode((l1.val + c) % 10)
                if l1.val + c >= 10: 
                    c = 1
                else: 
                    c = 0 
                l1 = l1.next
                node = node.next
        
            elif l2 and not l1:
                node.next = ListNode((l2.val + c) % 10)
                if l2.val + c >= 10: 
                    c = 1
                else: 
                    c = 0 
                l2 = l2.next
                node = node.next
        
        if c:
            node.next = ListNode(c)
            
        return root.next