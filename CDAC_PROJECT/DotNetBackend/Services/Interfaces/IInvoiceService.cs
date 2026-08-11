using DotNetBackend.DTOs.Invoice;

namespace DotNetBackend.Services.Interfaces
{
    public interface IInvoiceService
    {
        InvoiceResponseDto GenerateInvoice(InvoiceRequestDto request);

        InvoiceResponseDto GetInvoice(long invoiceId);
    }
}