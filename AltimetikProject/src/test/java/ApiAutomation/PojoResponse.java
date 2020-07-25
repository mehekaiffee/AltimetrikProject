package ApiAutomation;



import io.restassured.http.Headers;

public class PojoResponse
{
    private String args;

    private Headers headers;

    private Data data;

    private String form;

    private String files;

    private Json json;

    private String url;

    public String getArgs ()
    {
        return args;
    }

    public void setArgs (String args)
    {
        this.args = args;
    }

    public Headers getHeaders ()
    {
        return headers;
    }

    public void setHeaders (Headers headers)
    {
        this.headers = headers;
    }

    public  Object getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public String getForm ()
    {
        return form;
    }

    public void setForm (String form)
    {
        this.form = form;
    }

    public String getFiles ()
    {
        return files;
    }

    public void setFiles (String files)
    {
        this.files = files;
    }

    public Json getJson ()
    {
        return json;
    }

    public void setJson (Json json)
    {
        this.json = json;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [args = "+args+", headers = "+headers+", data = "+data+", form = "+form+", files = "+files+", json = "+json+", url = "+url+"]";
    }
}
