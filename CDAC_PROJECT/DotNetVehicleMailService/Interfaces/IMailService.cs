namespace VehicleMailService.Interfaces
{
    public interface IMailService
    {
        Task SendInvoiceMail(
            string email,
            string subject,
            string body,
            byte[] pdfBytes,
            string fileName);
    }
}