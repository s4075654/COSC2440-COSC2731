/** @see java.lang */
public interface Member
{
   /** @see java.lang
    * @param p the project specified in the parameter
    * @return whether the current Member object can lead the project specified in the parameter */
   abstract boolean joinProject(Project p);
}
