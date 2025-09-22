import java.util.*;


class Ticket
{
    private static int counter = 1;
    private int id;
    private String name;
    private String title;
    private String description;
    private String status;

    public Ticket(String name, String title, String description)
    {
        this.id = counter++;
        this.name = name;
        this.title = title;
        this.description = description;
        this.status ="Open";
    }

    public int getId()
    {
        return id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String newStatus)
    {
        this.status=newStatus;
    }
    
    @Override
    public String toString()
    {
        return "Ticket ID: " +id+
        "\nName: "+name+
        "\nTitle: "+title+
        "\nDescription: "+description+
        "\nStatus: "+status+"\n";
    }
}

class TicketSystem 
{
    private ArrayList<Ticket> tickets = new ArrayList<>();
    
    public void createTicket(String name, String title, String description)
    {
        Ticket ticket = new Ticket(name, title, description);
        tickets.add(ticket);
        System.out.println("Ticket Created Successfully with ID: "+ticket.getId());
    }

    public void viewTickets()
    {
        if(tickets.isEmpty())
        {
            System.out.println("No Tickets Available Now");
        }
        else
        {
            for(Ticket ticket: tickets)
            {
                System.out.println(ticket);
            }
        }
    }

    public void updateTicketStatus(int id, String newStatus)
    {
        for (Ticket ticket: tickets)
        {
            if(ticket.getId()==id)
            {
                ticket.setStatus(newStatus);
                System.out.println("Ticket "+id+" Updated Status: "+ newStatus);
                return;
            }
        }
        System.out.println("Ticket with ID "+id+" Not Found");
    }
}

public class TicketRaisingSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();
        int choice;
        do
        {
            System.out.println("\n===== Ticket Raising System =====");
            System.out.println("1. Raise a Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Update Ticket Status");
            System.out.println("4. Exit");
            System.out.print("Enter the Choice: ");
            System.out.println();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                {
                    System.out.print("Enter the Name: ");
                    String name = sc.nextLine();
                    System.out.println();
                    System.out.print("Enter the Ticket title: ");
                    String title = sc.nextLine();
                    System.out.println();
                    System.out.print("Enter the Ticket Description: ");
                    String desc = sc.nextLine();
                    system.createTicket(name, title, desc);
                    break;
                }
                case 2:
                {
                    system.viewTickets();
                    break;
                }
                case 3:
                {
                    System.out.println("Enter Ticket ID for Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new Status ( Open / In Progress / Closed ): ");
                    String status = sc.nextLine();
                    system.updateTicketStatus(id, status);
                    break;
                }
                case 4:
                {
                    System.out.println("Exiting Ticket System...");
                    break;
                }
                default:
                {
                    System.out.println("Invalid Choice, Try Again.");
                    break;
                }
            }
        } while (choice !=4); 
        sc.close();
    }
}
