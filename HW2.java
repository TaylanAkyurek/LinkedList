
class HW2
{
 
	// Node structure containing power and coefficient of variable
	static class Node
	{
	 // Your code here
		double coeff;
    int power;
    Node next;

    Node(double coeff,int power){
      this.coeff=coeff;
      this.power=power;
      this.next=null;
    }

	};
	
	//Function To Display The Linked list
	static void printList( Node ptr)
	{
		if (ptr == null) 
		{
			return;
		}
		else if (ptr.next != null)
		{
			while (ptr.next != null)
			{
				System.out.print( ptr.coeff + "x^" + ptr.power + " + ");
				ptr = ptr.next;
			}
		}
		System.out.println( ptr.coeff + "x^" + ptr.power);
	}
  
	// Create a node and return
	static Node createNode(double coeff, int power)
	{
	// Your code here
		Node newNode=new Node(coeff, power);
    newNode.next=null;
    return newNode;
	}
  
  	// Function add a new node
	static Node addnode(Node head, double coeff, int power)
	{
	// Your code here
  
  Node temp=head; 
  while(temp.next!=null){
    if(temp.power==power){
      temp.coeff+=coeff;
      return null;
    }
    temp=temp.next;
  }
  if(temp.power==power){
      temp.coeff+=coeff;
      return null;
  }

  temp.next=createNode(coeff, power);
  
  return null;
	 
	}
  static void sort(Node poly){
    Node temp=poly;
    Node comparator=null;
    int tempPower;
    double tempCoeff;
    while(temp!=null){
      comparator=temp.next;
      while(comparator!=null){
        if(comparator.power>temp.power){
          tempPower=temp.power;
          tempCoeff=temp.coeff;
          temp.power=comparator.power;
          temp.coeff=comparator.coeff;
          comparator.power=tempPower;
          comparator.coeff=tempCoeff;

        }
        comparator=comparator.next;
      }
      temp=temp.next;


    }
  

  }
	static Node multiply(Node poly1, Node poly2)
	{
	// Your code here
    Node sum=null;
    Node temp1=poly1;
    Node temp2=poly2;

    while(temp1!=null){
      temp2=poly2;
      while(temp2!=null){
       if(sum==null){
        sum=createNode(temp1.coeff*temp2.coeff,temp1.power+temp2.power);
        temp2=temp2.next;
       }
      else{
          addnode(sum,temp1.coeff*temp2.coeff,temp1.power+temp2.power);
        temp2=temp2.next;
        }
      }
      temp1=temp1.next;
    }
    sort(sum);
  return sum;
  }
	static Node add(Node poly1, Node poly2)
	{
    Node sum=null;
    Node current=null;
    Node temp1=poly1;
    Node temp2=poly2;
    while(temp1!=null){
      	if (sum == null)
		{
    sum = createNode(temp1.coeff,temp1.power);
			current = sum;
		} 
		else 
		{
			current.next =createNode(temp1.coeff,temp1.power);
			current = current.next;
		}
    temp1=temp1.next;
    }
    while(temp2!=null){
    addnode(sum,temp2.coeff,temp2.power);
    temp2=temp2.next;
    }
    sort(sum);
   return sum;
	}
  
  
}
