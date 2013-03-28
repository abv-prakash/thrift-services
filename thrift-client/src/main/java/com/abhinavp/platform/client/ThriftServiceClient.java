package com.abhinavp.platform.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;

import com.abhinavp.platform.thrift.TResult;
import com.abhinavp.platform.thrift.TUser;
import com.abhinavp.platform.thrift.UserService;


/**
 * @author abhinav.prakash
 * 
 */
public class ThriftServiceClient implements UserService.Iface
{

    private UserService.Client getUserServiceClient()
    {
        try
        {
            THttpClient tClient = new THttpClient("http://" + "localhost:8080" + "/rest-api/userservice");
            return new UserService.Client(new TBinaryProtocol(tClient));
        }
        catch (TTransportException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.abhinavp.platform.thrift.UserService.Iface#addUser(com.abhinavp.platform.thrift.TUser)
     */
    public TResult addUser(final TUser user) throws TException
    {
        UserService.Client userService = getUserServiceClient();

        if (userService != null)
        {
            return userService.addUser(user);
        }

        return null;
    }

    public static void main(final String args[])
    {
        ThriftServiceClient client = new ThriftServiceClient();
        TUser user = new TUser();

        user.setAccount("abhinav_account");
        user.setActive(true);
        try
        {
            TResult result = client.addUser(user);
            System.out.println(result.toString());
        }
        catch (TException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
