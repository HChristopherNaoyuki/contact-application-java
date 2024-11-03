// Package declaration
package Solution;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContactData
{
    private final Map<String, String[]> contacts;

    // Constructor to load contacts from the specified file
    public ContactData(String fileName)
    {
        contacts = new HashMap<>();
        loadContacts(fileName);
    }

    // Method to load contacts from a file
    private void loadContacts(String fileName)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length == 4)
                {
                    String name = parts[0].trim();
                    String mobile = parts[1].trim();
                    String work = parts[2].trim();
                    String email = parts[3].trim();
                    contacts.put(name, new String[]{mobile, work, email});
                }
                else
                {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + fileName);
        }
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to get all contact names
    public String[] getContactNames()
    {
        Set<String> names = contacts.keySet();
        return names.toArray(new String[0]);
    }

    // Method to get details of a specific contact
    public String[] getContactDetails(String name)
    {
        return contacts.get(name);
    }
}
