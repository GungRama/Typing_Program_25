package typing_program;
/*
 * @author GungRama
 */
import java.util.Scanner;

public class Typing_Program
{

    private static class typing_program extends Typing_Program {

        public typing_program() {
        }
    }
    class node 
    {
        String text;
        node next;node prev;
        public void insert(String text)
        {
            this.text=text;
        }
        public String getTEXT()
        {
        	return this.text;
        }
    }
    node head=null,tail=null,baru,temp,cetak;
    node del,after,before=null;
    public void add()
    {
        System.out.print("ketik 1 karakter\t:");
        Scanner input = new Scanner (System.in);
        String text;
        text = input.next();
        baru = new node();
        baru.insert(text);
        baru.next=null;
        if(head==null)
        {
            head=baru;
            tail=baru;
            temp=baru;
            head.next=null;
            before=new node();
            head.prev=before;
            before.next=head;
            before.prev=null;
        }
        else if (temp.next==null)
        {
            temp.next=baru;
            tail=baru;
            tail.prev=temp;
            temp=baru;
        }
        else if (temp.prev==null)
        {
            head.prev=baru;
            before.next=baru;
            baru.prev=before;
            baru.next=head;
            head=baru;
            temp=head;
            before.prev=null;
        }
        else
        {
            after=temp.next;
            temp.next=baru;
            after.prev=baru;
            baru.next=after;
            baru.prev=temp;
            temp=baru;
        }
        System.out.println("");
    }

    void del()
    {
        if(temp==before)
        {
         System.out.print("\ntidak ada yang dihapus\n");
        }
        else if(head==tail)
        {
            del=head;
            temp=before;
            del=null;
            head=null;
        }

        else if(temp.next==null)
        {
            tail=tail.prev;
            del=temp;
            temp=temp.prev;
            del=null;
            tail.next=null;
        }
        else if(temp==head)
        {
            del=head;
            temp=before;
            head=head.next;
            del=null;
            temp.next=head;
            head.prev=before;
        }
        else
        {
            del=temp;
            temp=temp.prev;
            del.next.prev=temp;
            temp.next=del.next;
            del=null;
        }
        System.out.print("\nContinue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    void sleft()
    {
        if(temp==before)
        {
            System.out.print("\npointer sudah paling kiri\n");
        }
        else
        {
        temp=temp.prev;
        }
        System.out.print("\nContinue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    void sright()
    {
        if(temp==tail)
        {
            System.out.print("\npointer sudah paling kanan\n");
        }
        else
        {
            temp=temp.next;
        }
        System.out.print("\nContinue...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    void print()
    {
        if(head!=null)
        {
            cetak=head;
            while(cetak!=null)
            {
                System.out.print(cetak.getTEXT());
                cetak=cetak.next;
            }
        }
        else
        {
            System.out.print("no text in here");
        }
        Scanner pause = new Scanner (System.in);
    }

     public static void main(String[] args)
     {
        Typing_Program funct = new typing_program();
        int n,i,pilih;
        System.out.print("Masukkan maksimum perintah:");
        Scanner input = new Scanner (System.in);
        n = input.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.print("\t<");
            funct.print();
            System.out.print(">\n\n");
            System.out.print("perintah ke-"+(i+1)+"\nMenu\t:\n");
            System.out.print("1.insert\n2.delete\n3.shift left\n4.shift right\n0.exit\n\n");
            System.out.print("pilih\t:");
            Scanner pil = new Scanner (System.in);
            pilih = pil.nextInt();
            switch(pilih)
            {
                case 1:funct.add();
                break;
                case 2:funct.del();
                break;
                case 3:funct.sleft();
                break;
                case 4:funct.sright();
                break;
                default: System.exit(0);
            }
        }
    }
}

